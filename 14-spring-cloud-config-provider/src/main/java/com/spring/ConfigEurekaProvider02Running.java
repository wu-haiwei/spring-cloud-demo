package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConfigEurekaProvider02Running {

    public static void main(String[] args) {
        SpringApplication.run(ConfigEurekaProvider02Running.class, args);
    }
}
