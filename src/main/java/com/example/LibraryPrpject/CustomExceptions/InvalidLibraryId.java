package com.example.LibraryPrpject.CustomExceptions;

public class InvalidLibraryId extends Exception{
    public InvalidLibraryId(String message){
        super(message);
    }
}
