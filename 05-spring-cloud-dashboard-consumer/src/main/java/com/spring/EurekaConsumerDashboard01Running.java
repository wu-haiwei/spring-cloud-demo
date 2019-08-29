package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringCloudApplication
@EnableHystrixDashboard
@EnableFeignClients(basePackages = "com.spring.service")
public class EurekaConsumerDashboard01Running {

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerDashboard01Running.class, args);
    }
}
