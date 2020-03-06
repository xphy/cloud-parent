package com.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @description: spring cloud eureka
 * spring cloud的注册中心
 * @EnableEurekaServer，该注解表明标注类是一个Eureka Server。
 * @author: Andy
 * @time: 2019/12/24 14:23
 */

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }

}
