package com.vison.canteen.core.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author huangwenshen 2018/5/12 11:26
 */
@Slf4j
@RestController
@RequestMapping("swagger")
public class SwaggerController {

    @GetMapping("/")
    public ModelAndView swaggerView(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView model = new ModelAndView();
        model.setViewName("swagger-ui");
        return model;
    }
}
