package com.example.iqro.db.model.exceptions;

public class NoSuchElementException extends RuntimeException{
    public NoSuchElementException(){
    }
    public NoSuchElementException(String message){
        super(message);
    }
}
