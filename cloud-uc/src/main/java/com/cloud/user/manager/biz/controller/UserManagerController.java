package com.cloud.user.manager.biz.controller;


import com.cloud.user.manager.base.until.JsonResult;
import com.cloud.user.manager.base.until.JwtUtil;
import com.cloud.user.manager.biz.bean.User;
import com.cloud.user.manager.biz.sevice.impl.UserManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：mmzs
 * @date ：Created in 2020/1/3 18:43
 * @description：用户控制类
 * @modified By：
 * @version: 1$
 */
@RestController(UserManagerController.BEAN_NAME)
@RequestMapping("/user")
@Slf4j
public class UserManagerController {
    static final String BEAN_NAME = "com.user.biz.controller.UserManagerController";

    private UserManagerService userManagerService;

    public UserManagerController(UserManagerService userManagerService) {
        this.userManagerService = userManagerService;
    }

//    @Value("${server.port}")
//    public String  foo;
    @RequestMapping("/login")
    public List<User> login(){
        return userManagerService.userLogin();
    }
    @RequestMapping("/register")
    public List<User> register(){
        return userManagerService.selectall();
    }

    /**
     * get方式
     * @param loginName
     * @param password
     * @return
     * @throws Exception
     */
    @RequestMapping("/jwt")
    public Object login(@RequestParam(value = "loginName",required = false) String loginName,
                        @RequestParam(value = "password",required = false) String password) throws Exception {
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("loginName", loginName);
        if ("1".equals(password)) {
            return JsonResult.success(JwtUtil.generateToken(claims));
        } else {
            return JsonResult.fail("登录帐号或者登录密码错误");
        }
    }
    /**
     * post方式
     * @return
     * @throws Exception
     */
    @RequestMapping("/jwtPost")
    public Object login(@RequestBody User user) throws Exception {
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("loginName", user.getUserName());
        return JsonResult.success(JwtUtil.generateToken(claims));
    }
    /**
     * post方式
     * @return
     * @throws Exception
     */
    @RequestMapping("/jwtPost1")
    public Object logina(String a,String b) throws Exception {
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("loginName", a);
        return JsonResult.success(JwtUtil.generateToken(claims));
    }

}
