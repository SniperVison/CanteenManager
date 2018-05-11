package com.vison.canteen.core.controller;

import com.vison.canteen.biz.enums.UserStatus;
import com.vison.canteen.biz.util.MD5Utils;
import com.vison.canteen.core.bean.PO.UserPO;
import com.vison.canteen.core.exception.CanteenException;
import com.vison.canteen.core.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by huangwenshen on 2018/3/8
 */
@Slf4j
@RestController
@RequestMapping("register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @PostMapping("sign-up")
    public Map<String, Object> submitRegister(@RequestParam("username") String username,
                                              @RequestParam("password") String password,
                                              @RequestParam("email") String email) throws CanteenException {
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        UserPO userPO = userService.getByUsername(username);
        if (userPO == null) {
            UserPO user = new UserPO();
            user.setEmail(email);
            user.setUsername(username);
            user.setPassword(MD5Utils.encrypt(username, password));
            user.setStatus(UserStatus.CERTIFIED);
            Boolean flag = userService.addUser(user);
            if (flag) {
                resultMap.put("status", 200);
                resultMap.put("message", "注册成功");
            } else {
                resultMap.put("status", 500);
                resultMap.put("message", "往数据库插入数据失败");
                log.error("往数据库插入数据失败");
                throw CanteenException.USER_INFO_INSERT_DATA_FAILURE_EXCEPTION;
            }
        } else {
            resultMap.put("status", 500);
            resultMap.put("message", "用户名已存在");
        }
        return resultMap;
    }

    @PostMapping("get-user-by-username")
    public Boolean checkUserName(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        UserPO userPO = userService.getByUsername(username);
        if (userPO == null) {
            return true;
        } else {
            return false;
        }
    }

}
