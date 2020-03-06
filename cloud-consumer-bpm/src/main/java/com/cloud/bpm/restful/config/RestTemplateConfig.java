package com.cloud.bpm.restful.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author ：mmzs
 * @date ：Created in 2020/3/3 11:48
 * @description：将RestTemplate放到spring容器之中
 * @modified By：
 * @version: 1$
 */
@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
