package com.vison.canteen.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理器,转404页面
 *
 * @author huangwenshen 2018/3/10 15:21
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final String DEFAULT_NOT_FOUND_VIEW = "404";

    private static final String DEFAULT_ERROR_VIEW = "500";

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception {
        ModelAndView model = new ModelAndView();
        model.addObject("exception", e);
        model.addObject("url", request.getRequestURL());
        model.setViewName(DEFAULT_ERROR_VIEW);
        return model;
    }

    @ExceptionHandler(value = CanteenException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView notFoundHandler(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView model = new ModelAndView();
        model.setViewName(DEFAULT_NOT_FOUND_VIEW);
        return model;
    }
}
