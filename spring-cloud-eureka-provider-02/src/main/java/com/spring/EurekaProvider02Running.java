package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaProvider02Running {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProvider02Running.class, args);
    }
}
