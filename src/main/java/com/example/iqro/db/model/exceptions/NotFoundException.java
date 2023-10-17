package com.example.iqro.db.model.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(){
    }
    public NotFoundException(String message){
    super(message);
    }
}
