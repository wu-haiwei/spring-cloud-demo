package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulService01Running {

    public static void main(String[] args) {
        SpringApplication.run(ZuulService01Running.class, args);
    }
}
