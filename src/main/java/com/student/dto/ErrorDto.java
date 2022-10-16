package com.student.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ErrorDto {

    private String message;
    private HttpStatus code;
}
