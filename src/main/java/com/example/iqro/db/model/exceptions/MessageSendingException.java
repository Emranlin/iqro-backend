package com.example.iqro.db.model.exceptions;

public class MessageSendingException extends RuntimeException{
    public MessageSendingException (){
    }
    public MessageSendingException ( String message){
        super(message);
    }
}
