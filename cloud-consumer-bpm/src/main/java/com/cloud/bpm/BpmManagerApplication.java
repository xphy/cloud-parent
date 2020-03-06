package com.cloud.bpm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ：mmzs
 * @date ：Created in 2020/3/3 11:03
 * @description：bpm消费者启动类
 * @modified By：
 * @version: 1.0$application.yml
 */
@SpringBootApplication
@EnableEurekaClient
public class BpmManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(BpmManagerApplication.class);
    }
}
