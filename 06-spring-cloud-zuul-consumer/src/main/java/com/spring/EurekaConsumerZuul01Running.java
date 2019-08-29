package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringCloudApplication
@EnableFeignClients(basePackages = "com.spring.service")
public class EurekaConsumerZuul01Running {

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerZuul01Running.class, args);
    }
}
