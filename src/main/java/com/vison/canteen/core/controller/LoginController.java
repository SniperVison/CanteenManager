package com.vison.canteen.core.controller;

import com.vison.canteen.biz.util.MD5Utils;
import com.vison.canteen.core.bean.PO.UserPO;
import com.vison.canteen.core.service.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author huangwenshen 2018/3/31 17:52
 */
@Slf4j
@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    VegetableService vegetableService;

    @Autowired
    MeatService meatService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    ComsumeService comsumeService;

    //默认启动页
    @GetMapping("/")
    public ModelAndView defaultView() {
        ModelAndView model = new ModelAndView();
        model.setViewName("login");
        return model;
    }

    @GetMapping("main")
    public ModelAndView mainView(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ModelAndView model = new ModelAndView();
        HttpSession session = request.getSession();
        UserPO user = (UserPO) session.getAttribute("user");
        request.setAttribute("user", user);
        Integer userNums = userService.getUserCount();
        request.setAttribute("userNums", userNums);
        Double comsumeMoney=comsumeService.getComsumeMoney(user.getCard());
        request.setAttribute("comsumeMoney",comsumeMoney);
        Integer vegetableLeft = vegetableService.getLeft();
        Integer meatLeft = meatService.getLeft();
        request.setAttribute("foodLeft", vegetableLeft + meatLeft);
        model.setViewName("main");
        return model;
    }

    @PostMapping("ajax-login")
    public Map<String, Object> submitLogin(@RequestParam("username") String username,
                                           @RequestParam("password") String password,
                                           @RequestParam("rememberMe") Boolean rememberMe) {
        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        Subject currentUser = SecurityUtils.getSubject();
        //没有登录认证，执行登录
        if (!currentUser.isAuthenticated()) {
            String newPassword = MD5Utils.encrypt(username, password);
            UsernamePasswordToken token = new UsernamePasswordToken(username, newPassword);
            token.setRememberMe(rememberMe);
            try {
                currentUser.login(token);
                resultMap.put("status", 200);
                resultMap.put("message", "登录成功");
                userService.updateLoginTime(username);
            } catch (UnknownAccountException uae) {
                log.error("用户名错误, username = [{}]", username);
                resultMap.put("status", 501);
                resultMap.put("message", "用户名或密码错误");
            } catch (IncorrectCredentialsException ice) {
                log.error("密码错误, password = [{}]", password);
                resultMap.put("status", 502);
                resultMap.put("message", "用户名或密码错误");
            } catch (LockedAccountException lae) {
                log.error("账户被锁定, [{}]", token.getPrincipal());
                resultMap.put("status", 503);
                resultMap.put("message", "账户被锁定");
            } catch (AuthenticationException ae) {
                log.error("登录失败, 原因为 = [{}]", ae.getMessage());
                resultMap.put("status", 504);
                resultMap.put("message", ae.getMessage());
            }
            return resultMap;
        } else {
            resultMap.put("status", 200);
            resultMap.put("message", "登录成功");
            return resultMap;
        }
    }


    @PostMapping("logout")
    public String logoutView(HttpServletRequest request, HttpServletResponse response) {
        UserPO subject = (UserPO) SecurityUtils.getSubject();
        log.error(subject.toString());
        SecurityUtils.getSubject().logout();
        return "redirect:/";
    }


    @GetMapping("403")
    public ModelAndView unauthorizedView() {
        ModelAndView model = new ModelAndView();
        model.setViewName("403");
        return model;
    }


}
