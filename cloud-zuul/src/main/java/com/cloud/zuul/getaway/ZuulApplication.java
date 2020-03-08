package com.cloud.zuul.getaway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author ：mmzs
 * @date ：Created in 2020/3/6 15:42
 * @description：zuul网关
 * @modified By：
 * @version: 1.0$
 */
@SpringBootApplication
@EnableZuulProxy
//@EnableDiscoveryClient
@EnableEurekaClient
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class);
    }
}
