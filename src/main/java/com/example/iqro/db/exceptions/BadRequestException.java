package com.example.iqro.db.exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException(){
    }
    public BadRequestException(String message){
        super(message);

    }
}
