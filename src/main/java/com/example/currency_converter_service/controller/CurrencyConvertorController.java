package com.example.currency_converter_service.controller;

import com.example.currency_converter_service.dto.CurrencyDetailDto;
import com.example.currency_converter_service.service.CurrencyConvertorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
public class CurrencyConvertorController {

    private final CurrencyConvertorService currencyConvertorService;

    @GetMapping("/convert")
    public ResponseEntity<CurrencyDetailDto> getConvertedCurrency(@RequestParam String from,
                                                                  @RequestParam String to,
                                                                  @RequestParam @Digits(integer = 5, fraction = 2) Double amount){
        CurrencyDetailDto currencyDetailDto = currencyConvertorService.convertCurrency(from, to, amount);
        return new ResponseEntity<>(currencyDetailDto, HttpStatus.OK);
    }

}
