package com.example.currency_converter_service.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CurrencyDetailDto {

    private String fromCurrency;
    private String toCurrency;
    private Double amount;
    private Double convertedAmount;
    private Double rate;
    private LocalDate asOf;
}
