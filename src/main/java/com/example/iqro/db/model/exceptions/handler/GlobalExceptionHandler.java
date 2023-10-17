package com.example.iqro.db.model.exceptions.handler;

import com.example.iqro.db.dto.response.ExceptionResponse;
import com.example.iqro.db.model.exceptions.AlreadyExistException;
import com.example.iqro.db.model.exceptions.BadRequestException;
import com.example.iqro.db.model.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse notFoundException(NotFoundException n) {
        return new ExceptionResponse(
                HttpStatus.NOT_FOUND,
                n.getMessage(),
                n.getClass().getSimpleName());
    }
    @ExceptionHandler(AlreadyExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse alreadyExistException(AlreadyExistException a) {
        return new ExceptionResponse(
                HttpStatus.BAD_REQUEST,
                a.getMessage(),
                a.getClass().getSimpleName());
    }
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse badRequestException(BadRequestException badRequestException) {
        return new ExceptionResponse(
                HttpStatus.BAD_REQUEST,
                badRequestException.getMessage(),
                badRequestException.getClass().getSimpleName());
    }
}
