package com.example.currency_converter_service.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Data
@AllArgsConstructor
public class ErrorResponseDto {
     private String error;
     private String message;

}
