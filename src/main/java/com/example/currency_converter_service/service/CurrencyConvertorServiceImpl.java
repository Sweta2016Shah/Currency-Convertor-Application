package com.example.currency_converter_service.service;

import com.example.currency_converter_service.dto.CurrencyDetailDto;
import com.example.currency_converter_service.entity.CurrencyDetail;
import com.example.currency_converter_service.exception.ResourceNotFoundException;
import com.example.currency_converter_service.repository.CurrencyConvertorRepository;
import jakarta.validation.ConstraintViolationException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConvertorServiceImpl implements CurrencyConvertorService{

    @Autowired
    private CurrencyConvertorRepository currencyConvertorRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CurrencyDetailDto convertCurrency(String fromCurrency, String toCurrency, Double amount) {

        CurrencyDetail currencyDetail = currencyConvertorRepository.findByFromCurrencyAndToCurrency(fromCurrency, toCurrency)
                .orElseThrow(()->new ResourceNotFoundException("No conversion path from" + fromCurrency + "to" + toCurrency +". Please try again later"));
        CurrencyDetailDto currencyDetailDto = modelMapper.map(currencyDetail, CurrencyDetailDto.class);
        currencyDetailDto.setAmount(amount);
        currencyDetailDto.setConvertedAmount(currencyDetailDto.getRate()*amount);

        return currencyDetailDto;
    }
}
