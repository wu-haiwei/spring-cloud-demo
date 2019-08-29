定义Eureka服务注册中心

1. 引入依赖
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>com.spring-cloud-starter-netflix-eureka-server</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>com.spring-boot-autoconfigure</artifactId>
    </dependency>
    
2. 添加配置文件 application.yml
    server:
      port: 8002 ## 服务端口
    
    eureka:
      instance:
        hostname: 127.0.0.1 ## 指定主机名
      client:
        register-with-eureka: false ## 表示不向注册中心注册自己
        fetch-registry: false   ## 指定此客户端是否能够获取eureka信息
        service-url:    ## 暴露服务中心地址
          defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka
          
          
3. 创建启动类 添加注解
    @EnableEurekaServer