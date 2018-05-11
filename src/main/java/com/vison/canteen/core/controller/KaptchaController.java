package com.vison.canteen.core.controller;

import com.vison.canteen.biz.config.kaptcha.Captcha;
import com.vison.canteen.biz.config.kaptcha.GifCaptcha;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author huangwenshen 2018/4/10 14:11
 */
@Slf4j
@RestController
@RequestMapping("kaptcha")
public class KaptchaController {

    /**
     * 获取验证码（Gif版本）
     *
     * @param response
     */
    @GetMapping("get-gif-code")
    public void getGifCode(HttpServletResponse response, HttpServletRequest request) {
        try {
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/gif");
            /**
             * gif格式动画验证码
             * 宽，高，位数。
             */
            Captcha captcha = new GifCaptcha(146, 33, 4);
            //输出
            captcha.out(response.getOutputStream());
            HttpSession session = request.getSession(true);
            //存入Session
            session.setAttribute("_code", captcha.text());
        } catch (Exception e) {
            System.err.println("获取验证码异常：" + e.getMessage());
        }
    }


    /**
     * 校验验证码是否输入正确
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @PostMapping("check-gif-code")
    public Boolean checkGifCode(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String kaptchaCode = request.getParameter("gifCode");
        String code = (String) session.getAttribute("_code");
        if (code.equalsIgnoreCase(kaptchaCode)) {
            return true;
        } else {
            return false;
        }
    }

}
