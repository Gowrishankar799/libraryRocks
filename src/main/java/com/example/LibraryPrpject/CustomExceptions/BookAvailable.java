package com.example.LibraryPrpject.CustomExceptions;

public class BookAvailable extends Exception{
    public BookAvailable(String message){
        super(message);
    }
}
