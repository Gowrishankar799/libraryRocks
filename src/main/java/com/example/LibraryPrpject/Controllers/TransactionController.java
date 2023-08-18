package com.example.LibraryPrpject.Controllers;

import com.example.LibraryPrpject.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @PostMapping("/addTransaction")
    public ResponseEntity addTransaction(@RequestParam("bookId") int bookId, @RequestParam("lId") int lId){
        try {
            String s = transactionService.addTransaction(bookId,lId);
            HttpHeaders headers = new HttpHeaders();
            headers.add("desc","Transaction Successfully");
            return new ResponseEntity(s,headers, HttpStatus.OK);
        }
        catch (Exception e){
            HttpHeaders headers = new HttpHeaders();
            headers.add("desc","Transaction Failed");
            return new ResponseEntity(e.getMessage(),headers, HttpStatus.EXPECTATION_FAILED);
        }
    }
}
