package com.example.accommodatedexchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AccommodatedExchangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccommodatedExchangeApplication.class, args);
    }

}
