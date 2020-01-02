package com.flash.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: LiLiang
 * @Date: 2020/1/2 16:15
 */
@Configuration
public class ConfigBean {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
