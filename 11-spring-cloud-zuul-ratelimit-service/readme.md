多维限流

1. 添加依赖
    <dependency>
        <groupId>com.marcosbarbero.cloud</groupId>
        <artifactId>spring-cloud-zuul-ratelimit</artifactId>
        <version>2.0.5.RELEASE</version>
    </dependency>
    
2. 添加配置
    ratelimit:
      enabled: true #开启限流
      default-policy: #设置限流策略
        refresh-interval: 3 #限流单位时间窗口
        limit: 3 #在指定的单位时间窗口内启动限流的限定值
        quota: 1 # 指定限流的时间窗口数
        type: user,origin,url #指定限流查验类型
 
 
