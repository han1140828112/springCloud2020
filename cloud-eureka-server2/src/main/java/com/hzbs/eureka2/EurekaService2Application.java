package com.hzbs.eureka2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <p>
 *
 * </p>
 *
 * @author Mr.Wxh
 * @version 0.1.0
 * @date 2020-04-26 13:18
 **/
@EnableEurekaServer
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class EurekaService2Application {
    public static void main(String[] args) {
        SpringApplication.run(EurekaService2Application.class,args);
    }
}