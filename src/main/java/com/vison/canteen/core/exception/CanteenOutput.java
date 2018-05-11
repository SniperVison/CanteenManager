package com.vison.canteen.core.exception;

import com.vison.canteen.biz.exception.CommonException;

/**
 * @author huangwenshen 2018/4/4 23:47
 */
public enum CanteenOutput implements CommonException.CommonOutput {

    ROLE_(700, "角色的"),

    ROLE_NULL(701, "角色对象为null"),

    ROLE_CANT_SET_ABLE(702, "新增角色时,默认可用,不能设置可用性"),

    ROLE_NULL_ID(703, "角色id不能为null"),

    ROLE_NULL_DATA(704, "该角色数据不存在"),

    USER_INFO_(751, "用户的"),

    USER_INFO_INSERT_DATA_FAILURE(752, "往数据库中插入数据失败"),

    USER_INFO_UPDATE_FAILURE(752, "用户往数据库更新数据失败"),

    USERDTO_NULL(753,"用户传输对象为null"),


    FILE_(800, "文件的"),

    FILE_NOT_FOUND(801, "文件不存在"),

    FILE_READING_ERROR(802, "文件读取错误");


    private int code;
    private String msg;

    CanteenOutput(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }

}
