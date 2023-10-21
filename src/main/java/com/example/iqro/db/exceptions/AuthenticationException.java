package com.example.iqro.db.exceptions;

public class AuthenticationException extends RuntimeException{
    public AuthenticationException (){
    }
    public AuthenticationException(String message){
        super(message);
    }
}
