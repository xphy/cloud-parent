package com.cloud.user.manager.restful;

import com.cloud.user.manager.base.until.ArrayUtil;
import com.cloud.user.manager.biz.bean.User;
import com.cloud.user.manager.biz.controller.UserManagerController;
import com.cloud.user.manager.biz.sevice.impl.UserManagerService;
import com.netflix.ribbon.proxy.annotation.Http;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：mmzs
 * @date ：Created in 2020/3/6 9:26
 * @description：restful接口
 * @modified By：
 * @version: 1.0$
 */
@RestController(UserManagerServiceRestful.BEAN_NAME)
@RequestMapping("/user")
public class UserManagerServiceRestful {
    static final String BEAN_NAME = "com.user.biz.controller.UserManagerServiceRestful";

    private UserManagerService userManagerService;

    public UserManagerServiceRestful(UserManagerService userManagerService) {
        this.userManagerService = userManagerService;
    }
    @GetMapping("/1.0/getAll")
    public ResponseEntity<List<User>> queryAll(){
        try {
            List<User> userAll = userManagerService.selectall();
            //如果为null的话返回404
            if (ArrayUtil.isEmpty(userAll)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            //正常返回
            return ResponseEntity.ok(userAll);
        }catch (Exception e){
            e.printStackTrace();
        }
        //服务端异常
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
