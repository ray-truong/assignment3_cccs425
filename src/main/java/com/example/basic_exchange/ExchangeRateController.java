package com.example.basic_exchange;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exchange-rate")
public class ExchangeRateController {

    private final ExchangeRateService exchangeRateService;

    public ExchangeRateController(ExchangeRateService exchangeRateService) {
        this.exchangeRateService = exchangeRateService;
    }

    @GetMapping("/basic/{from}/{to}")

    public ResponseEntity<ExchangeRate> getExchangeRate(@PathVariable String from, @PathVariable String to) {
        ExchangeRate exchangeRate = exchangeRateService.getExchangeRate(from.toUpperCase(), to.toUpperCase());
        if (exchangeRate != null) {
            return ResponseEntity.ok(exchangeRate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}