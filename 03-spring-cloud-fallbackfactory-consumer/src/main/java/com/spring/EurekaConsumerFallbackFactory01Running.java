package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringCloudApplication
@EnableFeignClients(basePackages = "com.spring.service")
public class EurekaConsumerFallbackFactory01Running {

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerFallbackFactory01Running.class, args);
    }
}
