package com.example.basic_exchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class ExchangeRateService {

    private final Map<String, String> exchangeRates = new HashMap<>();
    private final Environment env;



    public ExchangeRateService(Environment env) {
        this.env = env;
        loadExchangeRates();
    }

    public ExchangeRate getExchangeRate(String from, String to) {
        String port = env.getProperty("local.server.port");


        String rate = exchangeRates.get(from + to);
        if (rate != null) {
            return new ExchangeRate(from, to, rate, LocalDateTime.now().toString(),port);
        }
        return null;
    }

    private void loadExchangeRates() {
        ClassPathResource resource = new ClassPathResource("exchange_rates.txt");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 3) {
                    exchangeRates.put(parts[0] + parts[1], parts[2]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load exchange rates", e);
        }
    }
}
