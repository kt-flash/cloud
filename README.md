## 1. spring cloud测试项目部署

### 1.1. HOST文件配置

127.0.0.1 eureka7001.com
127.0.0.1 eureka7002.com
127.0.0.1 eureka7003.com

127.0.0.1 myzuul.com

127.0.0.1 config-3344.com

### 1.2. 项目结构

    <modules>
        <module>flash-dao</module>
        <module>flash-es</module>
        <module>flash-common</module>
        <module>flash-consumer-80</module>
        <module>flash-eureka-7001</module>
        <module>flash-eureka-7002</module>
        <module>flash-eureka-7003</module>
        <module>flash-provider-8001</module>
        <module>flash-provider-8002</module>
        <module>flash-provider-8003</module>
        <module>flash-consumer-feign</module>
        <module>flash-consumer-hystrix-dashboard</module>
        <module>flash-zuul-gateway-9527</module>
        <module>flash-config-3344</module>
        <module>flash-config-client-3355</module>
    </modules>
    

### 1.3. 项目启动

  1.启动flash-eureka-7001，flash-eureka-7002，flash-eureka-7003注册中心集群
  
  2.启动flash-provider-8001，flash-provider-8002，flash-provider-8003服务提供者
  
  3.启动flash-consumer-80或flash-consumer-feign服务消费者
  
  4.启动flash-zuul-gateway-9527路由网关，可通过如http://myzuul.com:9527/consumer/user/get/10访问微服务
  
  
  
