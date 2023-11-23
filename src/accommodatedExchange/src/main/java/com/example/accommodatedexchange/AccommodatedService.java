package com.example.accommodatedexchange;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class AccommodatedService {
    private final Environment env;
    private final RestTemplate restTemplate;
    private final Map<String, Double> exchangeRates = new HashMap<>();

    public AccommodatedService(Environment env, RestTemplate restTemplate) {
        this.env = env;
        this.restTemplate = restTemplate;
        loadExchangeRates();
    }

    private void loadExchangeRates() {
        ClassPathResource resource = new ClassPathResource("accomodated.csv");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String currency = parts[0].trim();
                    Double discount = Double.parseDouble(parts[2].trim());
                    exchangeRates.put(currency, discount); // Key is the currency code
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Failed to load exchange rates", e);
        }
    }


    public AccomodatedExchange getAccommodatedExchange(String from, String to, double amount) {
        String externalServicePort = env.getProperty("external.service.port");
        ResponseEntity<ExchangeRateResponse> response = restTemplate.getForEntity(
                "http://localhost:" + externalServicePort + "/exchange-rate/basic/" + from + "/" + to,
                ExchangeRateResponse.class
        );

        if (!response.getStatusCode().is2xxSuccessful() || response.getBody() == null) {
            throw new IllegalStateException("Failed to retrieve exchange rate");
        }

        double rate = response.getBody().getRate();
        Double discountRate = exchangeRates.get(from);
        if (discountRate == null) {
            throw new IllegalStateException("No discount rate found for currency pair: " + from);
        }

        double rawAmount = amount * rate;
        double discount = discountRate / 100;
        double accommodatedAmount = rawAmount * (1 + discount);
        String time = LocalDateTime.now().toString();
        String sourceEnvironment = env.getProperty("local.server.port");

        return new AccomodatedExchange(from, to, rate, amount, discountRate, rawAmount, accommodatedAmount, time, sourceEnvironment, externalServicePort);
    }
}

class ExchangeRateResponse {
    public ExchangeRateResponse(){

    }
    public ExchangeRateResponse(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    private double rate;

}