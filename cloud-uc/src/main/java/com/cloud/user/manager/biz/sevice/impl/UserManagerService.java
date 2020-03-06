package com.cloud.user.manager.biz.sevice.impl;


import com.cloud.user.manager.biz.bean.User;

import java.util.List;

/**
 * @author ：mmzs
 * @date ：Created in 2020/1/3 18:43
 * @description：用户业务层接口
 * @modified By：
 * @version: 1$
 */
public interface UserManagerService {
    String BEAN_NAME = "com.user.biz.sevice.impl.UserLoginServiceImpl";
     boolean userRegister();
     List<User> userLogin();
     int deleteByPrimaryKey(Integer id);
     //筛选出所有的用户
     List<User> selectall();

}
