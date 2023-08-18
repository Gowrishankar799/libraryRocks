package com.example.LibraryPrpject.CustomExceptions;

public class MaxLimitBooksException extends Exception{
    public MaxLimitBooksException(String message){
        super(message);
    }
}
