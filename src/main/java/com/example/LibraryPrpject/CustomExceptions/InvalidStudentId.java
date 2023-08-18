package com.example.LibraryPrpject.CustomExceptions;

public class InvalidStudentId extends Exception{
    public InvalidStudentId(String message){
        super(message);
    }
}
