package com.vison.canteen.core.controller;

import com.vison.canteen.biz.bean.ResponseDTO;
import com.vison.canteen.biz.bean.UserOnline;
import com.vison.canteen.core.bean.PO.UserPO;
import com.vison.canteen.core.service.SessionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author huangwenshen 2018/5/11 19:29
 */
@Slf4j
@RestController
@RequestMapping("session")
public class SessionController {

    @Autowired
    SessionService sessionService;

    @GetMapping("/")
    public ModelAndView onlineView(HttpServletRequest request, HttpServletResponse response) {
        UserPO user = (UserPO) request.getSession().getAttribute("user");
        request.setAttribute("user", user);
        ModelAndView model = new ModelAndView();
        model.setViewName("online");
        return model;
    }

    @PostMapping("list")
    public List<UserOnline> list(HttpServletRequest request, HttpServletResponse response) {
        return sessionService.list();
    }


    @RequiresPermissions("user:kickout")
    @PostMapping("forceLogout")
    public ResponseDTO forceLogout(String id) {
        try {
            sessionService.forceLogout(id);
            return ResponseDTO.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDTO.error("踢出用户失败");
        }

    }

}

