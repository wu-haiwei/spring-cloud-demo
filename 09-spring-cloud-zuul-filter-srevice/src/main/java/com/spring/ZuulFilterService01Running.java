package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulFilterService01Running {

    public static void main(String[] args) {
        SpringApplication.run(ZuulFilterService01Running.class, args);
    }
}
