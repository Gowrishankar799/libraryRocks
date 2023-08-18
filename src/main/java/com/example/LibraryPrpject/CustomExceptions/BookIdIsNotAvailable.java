package com.example.LibraryPrpject.CustomExceptions;

public class BookIdIsNotAvailable extends Exception{
    public BookIdIsNotAvailable(String message){
        super(message);
    }
}
