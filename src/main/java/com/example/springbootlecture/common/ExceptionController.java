package com.example.springbootlecture.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ExceptionResponse> noSuchElementException(NoSuchElementException e){

       ExceptionResponse exceptionResponse = new ExceptionResponse("데이터 좀 잘 빼자", HttpStatus.INTERNAL_SERVER_ERROR.value());
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponse);
    }}

