package com.example.doumiproject.exception;

import ch.qos.logback.core.spi.ErrorCodes;

import com.example.doumiproject.exception.coteboard.CoteBoardAccessDeniedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CoteBoardAccessDeniedException.class)
    public ResponseEntity<ErrorForm> CoteBoardLoginFailException(CoteBoardAccessDeniedException ex) {
        return new ResponseEntity<>(new ErrorForm("잘못된 접근입니다", HttpStatus.FORBIDDEN.value()),
                HttpStatusCode.valueOf(HttpStatus.FORBIDDEN.value()));
    }

}
