package com.example.LibraryPrpject.Controllers;

import com.example.LibraryPrpject.Enum.Catagory;
import com.example.LibraryPrpject.RequestDto.BookIsSetAuthor;
import com.example.LibraryPrpject.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    public ResponseEntity addBook(@RequestBody BookIsSetAuthor bookIsSetAuthor) {
        try {
            String s = bookService.addBook(bookIsSetAuthor);
            HttpHeaders headers = new HttpHeaders();
            headers.add("desc", "add Book to the database");
            return new ResponseEntity(s, headers, HttpStatus.OK);
        } catch (Exception e) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("desc", "author id is not valid");
            return new ResponseEntity(e.getMessage(), headers, HttpStatus.EXPECTATION_FAILED);
        }
    }
    @GetMapping("/getNamesbyFiction")
    public ResponseEntity getNamesByFiction(@RequestParam("catagory") Catagory catagory){
        List<String>list = bookService.getNamesByFiction(catagory);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","list of books which is related to fiction");
        return new ResponseEntity(list,headers,HttpStatus.OK);
    }
}
