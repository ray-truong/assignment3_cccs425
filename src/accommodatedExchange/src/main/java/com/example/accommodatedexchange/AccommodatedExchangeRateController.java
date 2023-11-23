package com.example.accommodatedexchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/exchange-rate")
public class AccommodatedExchangeRateController {

    private final RestTemplate restTemplate;
    private final AccommodatedService accommodatedService;

    @Autowired
    public AccommodatedExchangeRateController(RestTemplate restTemplate, AccommodatedService accommodatedService) {
        this.restTemplate = restTemplate;
        this.accommodatedService = accommodatedService;
    }

    @GetMapping("/basic/{from}/{to}/{amount}")
    public ResponseEntity<?> getAccommodatedExchangeRate(@PathVariable String from, @PathVariable String to, @PathVariable double amount) {
        try {
            AccomodatedExchange exchange = accommodatedService.getAccommodatedExchange(from, to, amount);
            return ResponseEntity.ok(exchange);
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
