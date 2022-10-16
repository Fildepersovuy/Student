package com.student.exceptions;

import com.student.dto.ErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.NoSuchElementException;

@Slf4j
@ControllerAdvice
public class DefaultAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDto> handleEmptyInput(IllegalArgumentException illegalArgumentException) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(illegalArgumentException.getMessage());
        errorDto.setCode(HttpStatus.BAD_REQUEST);

        log.error("аргумент неправильного типа " + illegalArgumentException);

        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorDto> handleNoSuchElementException(NoSuchElementException noSuchElementException) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(noSuchElementException.getMessage());
        errorDto.setCode(HttpStatus.NOT_FOUND);

        log.error("заправшиваемый элемент не существует " + noSuchElementException);

        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<ErrorDto> handleIOException(IOException ioException) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(ioException.getMessage());
        errorDto.setCode(HttpStatus.NOT_FOUND);

        log.error("ошибка ввода вывода " + ioException);

        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDto> handleConstraintViolationException(ConstraintViolationException constraintViolationException) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(constraintViolationException.getMessage());
        errorDto.setCode(HttpStatus.BAD_REQUEST);

        log.error("ошибка валидации данных " + constraintViolationException);

        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

}
