package com.vison.canteen.core.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理器,转404页面
 *
 * @author huangwenshen 2018/3/10 15:21
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final String DEFAULT_ERROR_VIEW = "404";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception {
        ModelAndView model = new ModelAndView();
        model.addObject("exception", e);
        model.addObject("url", request.getRequestURL());
        model.setViewName(DEFAULT_ERROR_VIEW);
        return model;
    }

}
