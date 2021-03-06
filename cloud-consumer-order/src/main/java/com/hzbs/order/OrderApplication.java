package com.hzbs.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>
 * 主启动类
 * </p>
 *
 * @author Mr.Wxh
 * @version 0.1.0
 * @date 2020-04-25 18:40
 **/
@EnableEurekaClient
@EnableSwagger2
@ComponentScan("com.hzbs")
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
}