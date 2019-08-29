package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulTokenbucketService01Running {

    public static void main(String[] args) {
        SpringApplication.run(ZuulTokenbucketService01Running.class, args);
    }
}
