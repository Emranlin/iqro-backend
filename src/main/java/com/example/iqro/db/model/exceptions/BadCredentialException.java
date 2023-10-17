package com.example.iqro.db.model.exceptions;

public class BadCredentialException extends RuntimeException {
    public BadCredentialException(){
    }
    public BadCredentialException(String message){
    super(message);
    }
}
