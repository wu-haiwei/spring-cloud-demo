package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.spring.service")
public class EurekaConsumerFeign01Running {

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerFeign01Running.class, args);
    }
}
