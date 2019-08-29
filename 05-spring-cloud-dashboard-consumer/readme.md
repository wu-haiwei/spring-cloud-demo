这里监控和被监控端都写在一个工程中

监控端添加依赖:
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
    </dependency>
    
    
启动类添加注解:
    @SpringCloudApplication
    @EnableHystrixDashboard
    
被监控端添加依赖:
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
    
被监控端添加配置:
    management:
      endpoints:
        web:
          exposure:
            include: "*"
    
    hystrix:
      command:
        default:
          execution:
            isolation:
              thread:
                timeoutInMilliseconds: 3000
                
启动类添加注解:
    @SpringCloudApplication
    @EnableFeignClients(basePackages = "com.spring.service")
    
访问:
    http://ip:port/hystrix
    
    stream地址: http://ip:port/actuator/hystrix.stream