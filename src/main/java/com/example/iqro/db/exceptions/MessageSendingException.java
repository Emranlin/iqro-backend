package com.example.iqro.db.exceptions;

public class MessageSendingException extends RuntimeException{
    public MessageSendingException (){
    }
    public MessageSendingException ( String message){
        super(message);
    }
}
