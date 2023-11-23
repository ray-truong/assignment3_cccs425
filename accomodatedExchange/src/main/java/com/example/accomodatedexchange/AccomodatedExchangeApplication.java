package com.example.accomodatedexchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AccomodatedExchangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccomodatedExchangeApplication.class, args);
    }

}
