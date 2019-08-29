openFeign 集成

1. 添加依赖
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>com.spring-cloud-starter-openfeign</artifactId>
    </dependency>
    
2. 添加接口类
    `@Service
     @FeignClient("SPRING-CLOUD-EUREKA-PROVIDER-01")
     @RequestMapping("/api/user")
     public interface IUserService {
     
         @GetMapping("/detail/{userId}")
         UserInfo queryUser(@PathVariable("userId") Integer userId);
     
         @GetMapping("/list")
         List<UserInfo> listUser();
     
         @PostMapping("/save")
         Integer save(@RequestBody UserInfo userInfo);
     
         @DeleteMapping("/delete/{userId}")
         Integer delete(@PathVariable("userId") Integer userId);
     }`
 
 3. 启动类开启 feign 功能
    `@SpringBootApplication
     @EnableEurekaClient
     @EnableFeignClients(basePackages = "com.spring.service")`
 
 4. 添加配置
    feign:
      client:
        config:
          default:
            connectTimeout: 5000 # 连接提供者超时时间
            readTimeout: 5000 # 发出请求到获取响应超时时间
    
      compression:
        request:
          enabled: true  # 开启对请求的压缩
          mime-types: ["text/xml", "application/xml", "application/json"] # 指定对那些类型的数据进行压缩
          min-request-size: 2048  # 指定压缩的最小文件大小, 单位字节
        response:
          enabled: true # 开启请求响应的压缩


5. 负载均衡策略, 默认是 轮询
    轮询: com.netflix.loadbalancer.RoundRobinRule
    随机: com.netflix.loadbalancer.RandomRule
    重试: com.netflix.loadbalancer.RetryRule 
          先按照 RoundRobinRule 策略获取 provider，若获取失败，则在指定的时限内重试。默认的时限为 500 毫秒
    并发最小: com.netflix.loadbalancer.BestAvailableRule
          选择并发量最小的 provider，即连接的消费者数量最少的 provider。
    可用连接: com.netflix.loadbalancer.AvailabilityFilteringRule
          过滤掉处于断路器跳闸状态的 provider，或已经超过连接极限的 provider，对剩余 provider 采用轮询策略。
          
          
    跟换负载均衡策略:
        # 修改负载均衡策略, 方式一,修改配置
        abcmsc-provider-depart: # 要负载均衡的提供者微服务名称
          ribbon: # 指定要使用的负载均衡策略
            NFLoadBalancerRuleClassName: com.netflix.loadbalancer.RandomRule
            
         方式二, 创建配置类
         @Bean
         public IRule loadbalanceRule(){
            return new RoundRobinRule();
         }
         
         
6. 自定义负载均衡策略
   实现 IRule 接口
   `public class CustomRule implements IRule {
    
        private ILoadBalancer lb;
    
        @Override
        public Server choose(Object key) {
            // TODO 实现逻辑
            return null;
        }
    
        @Override
        public void setLoadBalancer(ILoadBalancer lb) {
            this.lb = lb;
        }
    
        @Override
        public ILoadBalancer getLoadBalancer() {
            return lb;
        }
    }`
         
        
