package com.example.currency_converter_service.service;

import com.example.currency_converter_service.dto.CurrencyDetailDto;

public interface CurrencyConvertorService {

    CurrencyDetailDto convertCurrency(String fromCurrency,String toCurrency, Double amount);
}
