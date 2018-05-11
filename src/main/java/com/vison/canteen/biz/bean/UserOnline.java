package com.vison.canteen.biz.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huangwenshen 2018/5/11 19:44
 */
@Data
public class UserOnline implements Serializable {

    private static final long serialVersionUID = 3828664348416633856L;

    // session id
    private String id;
    // 用户id
    private String userId;
    // 用户名称
    private String username;
    // 用户主机地址
    private String host;
    // 用户登录时系统IP
    private String systemHost;
    // 状态
    private String status;
    // session创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTimestamp;
    // session最后访问时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastAccessTime;
    // 超时时间
    private Long timeout;
    // 所在地
    private String location;

}
