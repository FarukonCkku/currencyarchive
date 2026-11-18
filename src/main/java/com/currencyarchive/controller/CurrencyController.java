package com.currencyarchive.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class CurrencyController {

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of(
                "status", "UP",
                "service", "currency-archive"
        );
    }

    @GetMapping("/currencies")
    public List<Map<String, String>> getCurrencies() {
        return List.of(
                Map.of("code", "USD", "name", "US Dollar"),
                Map.of("code", "EUR", "name", "Euro"),
                Map.of("code", "RUB", "name", "Russian Ruble"),
                Map.of("code", "CNY", "name", "Chinese Yuan")
        );
    }

    @GetMapping("/rates/{currency}")
    public Map<String, Object> getRates(@PathVariable String currency) {
        return Map.of(
                "currency", currency.toUpperCase(),
                "base", "RUB",
                "rates", List.of(
                        Map.of("date", "2025-11-01", "value", 97.45),
                        Map.of("date", "2025-11-02", "value", 96.80),
                        Map.of("date", "2025-11-03", "value", 98.12)
                )
        );
    }
}
