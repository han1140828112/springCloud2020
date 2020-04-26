package com.hzbs.order.controller.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 * RestTemplate服务远程调用配置类
 * </p>
 *
 * @author Mr.Wxh
 * @version 0.1.0
 * @date 2020-04-25 21:49
 **/
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}