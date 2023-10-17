package com.example.iqro.db.model.exceptions;

public class AuthenticationException extends RuntimeException{
    public AuthenticationException (){
    }
    public AuthenticationException(String message){
        super(message);
    }
}
