package com.example.iqro.db.exceptions;

public class NoSuchElementException extends RuntimeException{
    public NoSuchElementException(){
    }
    public NoSuchElementException(String message){
        super(message);
    }
}
