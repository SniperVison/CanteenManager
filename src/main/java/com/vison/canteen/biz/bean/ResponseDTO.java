package com.vison.canteen.biz.bean;

import java.util.HashMap;

/**
 * @author huangwenshen 2018/4/16 22:09
 */
public class ResponseDTO extends HashMap<String, Object> {

    //成功
    private static final Integer SUCCESS = 200;

    //警告
    private static final Integer WARN = 400;

    //异常失败
    private static final Integer FAIL = 500;

    public ResponseDTO() {
        put("code",SUCCESS);
        put("msg","操作成功");
    }

    public static ResponseDTO error(Object msg){
        ResponseDTO responseDTO=new ResponseDTO();
        responseDTO.put("code",FAIL);
        responseDTO.put("msg",msg);
        return responseDTO;
    }

    public static ResponseDTO warn(Object msg) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.put("code", WARN);
        responseDTO.put("msg", msg);
        return responseDTO;
    }

    public static ResponseDTO ok(Object msg) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.put("code", SUCCESS);
        responseDTO.put("msg", msg);
        return responseDTO;
    }

    public static ResponseDTO ok() {
        return new ResponseDTO();
    }

    public static ResponseDTO error() {
        return ResponseDTO.error("");
    }

    @Override
    public ResponseDTO put(String key, Object value) {
        super.put(key, value);
        return this;
    }

}
