package com.example.LibraryPrpject.Controllers;

import com.example.LibraryPrpject.Enum.CardStatus;
import com.example.LibraryPrpject.Models.Student;
import com.example.LibraryPrpject.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/addStudent")
    public ResponseEntity addStudent(@RequestBody Student student){
        try {
            String s = studentService.addStudent(student);
            HttpHeaders headers = new HttpHeaders();
            headers.add("desc","add Student in the database");
            return new ResponseEntity(s,headers, HttpStatus.OK);
        }
        catch (Exception e){
            HttpHeaders headers = new HttpHeaders();
            headers.add("desc","Student id is not sent in the database");
            return new ResponseEntity(e.getMessage(),headers, HttpStatus.OK);
        }
    }
    @GetMapping("/cardStatusOfTheStudent")
    public ResponseEntity cardStatusOfTheStudent(@RequestParam("id") int id){
        try {
            CardStatus cardStatus = studentService.cardStatusOfTheStudent(id);
            HttpHeaders headers = new HttpHeaders();
            headers.add("desc","by using student id we get cardstatus of the student");
            return new ResponseEntity(cardStatus,headers, HttpStatus.OK);
        }
        catch (Exception e){
            HttpHeaders headers = new HttpHeaders();
            headers.add("desc","student id is not valid");
            return new ResponseEntity(e.getMessage(),headers, HttpStatus.OK);
        }
    }
}
