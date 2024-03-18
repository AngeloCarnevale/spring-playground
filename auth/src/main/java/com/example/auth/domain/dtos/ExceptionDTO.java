package com.example.auth.domain.dtos;

import org.springframework.http.HttpStatus;

public record ExceptionDTO (String message, HttpStatus statusCode){
}
