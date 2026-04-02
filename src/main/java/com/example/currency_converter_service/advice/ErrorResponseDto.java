package com.example.currency_converter_service.advice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class ErrorResponseDto {
     private String error;
     private String message;

}
