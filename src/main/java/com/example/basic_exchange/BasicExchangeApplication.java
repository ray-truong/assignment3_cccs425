package com.example.basic_exchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BasicExchangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicExchangeApplication.class, args);
    }

}
