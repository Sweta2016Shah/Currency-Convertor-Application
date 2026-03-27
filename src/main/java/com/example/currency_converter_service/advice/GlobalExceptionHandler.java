package com.example.currency_converter_service.advice;

import com.example.currency_converter_service.exception.ResourceNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundException exception){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto("RATE_NOT_FOUND", exception.getLocalizedMessage());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleConstraintViolationException(Exception ex) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto("INVALID_AMOUNT",  "Parameter 'amount' must be a positive number");
        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }

}
