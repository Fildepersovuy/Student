package com.student.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.util.NoSuchElementException;

@ControllerAdvice
public class DefaultAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleEmptyInput(IllegalArgumentException illegalArgumentException) {
        return new ResponseEntity<>("Invalid input field, Please look into it", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuchElementException) {
        return new ResponseEntity<>("No value is present in BD, Please change your request", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<String> handleIOException(IOException noSuchElementException) {
        return new ResponseEntity<>("IOException occurred", HttpStatus.NOT_FOUND);
    }

}
