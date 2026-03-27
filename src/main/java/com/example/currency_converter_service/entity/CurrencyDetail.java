package com.example.currency_converter_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long conversionId;

    private String fromCurrency;
    private String toCurrency;
    private Double amount;
    private Double convertedAmount;
    private Double rate;
    private LocalDate asOf;
}
