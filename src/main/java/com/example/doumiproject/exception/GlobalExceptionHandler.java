package com.example.doumiproject.exception;

import ch.qos.logback.core.spi.ErrorCodes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PageNegativeValueException.class)
    public ResponseEntity<ErrorForm> PageNegativeValueException(
            PageNegativeValueException ex
    ) {
        // 개발자에게 알려줄 수 있는 수단 필요
        return ResponseEntity.status(400).body(new ErrorForm("rrr", 1));
    }

}
