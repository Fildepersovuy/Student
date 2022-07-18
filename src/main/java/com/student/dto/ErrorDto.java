package com.student.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ErrorDto {

    String message;
    HttpStatus code;
}
