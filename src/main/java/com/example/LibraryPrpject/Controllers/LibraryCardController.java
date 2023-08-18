package com.example.LibraryPrpject.Controllers;

import com.example.LibraryPrpject.Repository.StudentRepository;
import com.example.LibraryPrpject.RequestDto.LibraryCardToAddAuthor;
import com.example.LibraryPrpject.Service.LibraryCardService;
import com.example.LibraryPrpject.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addLibraryCard")
public class LibraryCardController {
    @Autowired
    LibraryCardService libraryCardService;
    @PostMapping("/addLibraryCard")
   public ResponseEntity addLibraryCard(@RequestBody LibraryCardToAddAuthor libraryCardToAddAuthor){
        try {
            String s = libraryCardService.addLibraryCard(libraryCardToAddAuthor);
            HttpHeaders headers = new HttpHeaders();
            headers.add("desc","add library card to the database");
            return new ResponseEntity(s,headers, HttpStatus.OK);
        }
        catch (Exception e){
            HttpHeaders headers = new HttpHeaders();
            headers.add("desc","Student id is not valid");
            return new ResponseEntity(e.getMessage(),headers, HttpStatus.EXPECTATION_FAILED);
        }
    }
}
