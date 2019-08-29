package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaProvider01Running {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProvider01Running.class, args);
    }
}
