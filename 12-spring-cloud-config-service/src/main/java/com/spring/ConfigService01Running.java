package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigService01Running {

    public static void main(String[] args) {
        SpringApplication.run(ConfigService01Running.class, args);
    }
}
