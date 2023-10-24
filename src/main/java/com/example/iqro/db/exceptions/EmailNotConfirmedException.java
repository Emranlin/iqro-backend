package com.example.iqro.db.exceptions;

public class EmailNotConfirmedException extends RuntimeException{
    public EmailNotConfirmedException() {
        super();
    }

    public EmailNotConfirmedException(String message) {
        super(message);
    }
}
