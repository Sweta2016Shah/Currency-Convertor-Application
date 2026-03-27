package com.example.currency_converter_service.repository;

import com.example.currency_converter_service.entity.CurrencyDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyConvertorRepository extends JpaRepository<CurrencyDetail, Long> {

    Optional<CurrencyDetail> findByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency);
}
