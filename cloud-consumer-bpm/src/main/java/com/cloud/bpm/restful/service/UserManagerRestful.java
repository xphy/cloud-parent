package com.cloud.bpm.restful.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ：mmzs
 * @date ：Created in 2020/3/6 10:36
 * @description：请求user用户的接口
 * @modified By：
 * @version: 1.0$
 */
@RestController(UserManagerRestful.BEAN_NAME)
@RequestMapping("/user")
public class UserManagerRestful {
    static final String BEAN_NAME = "com.user.biz.controller.UserManagerController";
    //定义请求服务的地址
    private String userUrl = "http://localhost:9998/user/1.0";
    private RestTemplate restTemplate;

    public UserManagerRestful(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @RequestMapping("/test1")
    public String getEurekaServiceInfo(){
        /**
         * exchange(url,type,paras,resutType)
         * url：请求地址
         * type：请求类型 get,post
         * paras：参数
         * resutType：返回值类型
         */
        String url= userUrl + "/getAll";
        HttpMethod type=HttpMethod.GET;
        RequestEntity<String> paras=null;
        ResponseEntity<String> responseEntity=restTemplate.exchange(url,type,paras,String.class);
        return responseEntity.getBody();
    }
}
