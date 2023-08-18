package com.example.LibraryPrpject.Controllers;

import com.example.LibraryPrpject.Models.Author;
import com.example.LibraryPrpject.RequestDto.UpdatePenNameAndName;
import com.example.LibraryPrpject.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @PostMapping("/addAuthor")
    public ResponseEntity addAuthor(@RequestBody Author author){
        try {
            String s = authorService.addAuthor(author);
            HttpHeaders headers = new HttpHeaders();
            headers.add("desc","add Author to database");
            return new ResponseEntity(s,headers, HttpStatus.OK);
        }
        catch (Exception e){
            HttpHeaders headers = new HttpHeaders();
            headers.add("desc","author id is not sent body parameter or author id is not sent in the Postman");
            return new ResponseEntity(e.getMessage(),headers, HttpStatus.EXPECTATION_FAILED);
        }
    }
    @PutMapping("/updateAuthor")
    public ResponseEntity updateAuthor(@RequestBody UpdatePenNameAndName updatePenNameAndName) {
        try {
            String s = authorService.updateAuthor(updatePenNameAndName);
            HttpHeaders headers = new HttpHeaders();
            headers.add("desc","Update author");
            return new ResponseEntity(s,headers, HttpStatus.OK);
        }
        catch (Exception e){
            HttpHeaders headers = new HttpHeaders();
            headers.add("desc","add Author to database");
            return new ResponseEntity(e.getMessage(),headers, HttpStatus.EXPECTATION_FAILED);
        }
    }
    @GetMapping("/listOfBooks")
    public ResponseEntity listOfBooks(@RequestParam("id") int id){
        try {
            List<String>list = authorService.listOfBooks(id);
            HttpHeaders headers = new HttpHeaders();
            headers.add("desc","list of books of by authorid");
            return new ResponseEntity(list,headers, HttpStatus.OK);
        }
        catch (Exception e){
            HttpHeaders headers = new HttpHeaders();
            headers.add("desc","Author id is not valid");
            return new ResponseEntity(e.getMessage(),headers, HttpStatus.EXPECTATION_FAILED);
        }
    }
    @GetMapping("/getAuthorById")
    public ResponseEntity getAuthorById(@RequestParam("id") int id){
        try {
            Author author= authorService.getAuthorById(id);
            HttpHeaders headers = new HttpHeaders();
            headers.add("desc","Get Author by Id");
            return new ResponseEntity(author,headers, HttpStatus.OK);
        }
        catch (Exception e){
            HttpHeaders headers = new HttpHeaders();
            headers.add("desc","Author id is not valid");
            return new ResponseEntity(e.getMessage(),headers, HttpStatus.EXPECTATION_FAILED);
        }
    }
}
