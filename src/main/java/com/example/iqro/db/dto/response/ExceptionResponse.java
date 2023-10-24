package com.example.iqro.db.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@Setter
@NoArgsConstructor
public class ExceptionResponse {
    private HttpStatus httpStatus;
    private String message;
    private String exceptionClassName;

    public ExceptionResponse(HttpStatus httpStatus, String message, String exceptionClassName) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.exceptionClassName = exceptionClassName;
    }
}
