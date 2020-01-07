package com.flash.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: LiLiang
 * @Date: 2019/11/19 11:12
 */
@SpringBootApplication(scanBasePackages={"com.flash"})
@EnableTransactionManagement
@MapperScan("com.flash.mapper")
@EnableDiscoveryClient
public class ProviderApplication8001 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication8001.class, args);
    }

}
