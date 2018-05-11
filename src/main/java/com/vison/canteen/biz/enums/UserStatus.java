package com.vison.canteen.biz.enums;

import com.baomidou.mybatisplus.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.io.Serializable;

/**
 * 用户状态
 *
 * @author huangwenshen 2018/4/4 23:25
 */
@Getter
public enum UserStatus implements IEnum {

    //状态(0代表创建未认证, 1代表正常状态， 2代表锁定状态)
    UNCERTIFIED(0, "未认证"),
    CERTIFIED(1, "已认证"),
    LOCKED(2, "被锁定");

    private int status;
    private String statusName;

    UserStatus(final int status, final String statusName) {
        this.status = status;
        this.statusName = statusName;
    }

    @Override
    public Serializable getValue() {
        return status;
    }

   /* public static UserStatus select(String statusName) {
        if (StringUtils.isBlank(statusName)) {
            return null;
        }
        for (UserStatus userStatus : UserStatus.values()) {
            if (userStatus.getStatusName() ==statusName) {
                return userStatus;
            }
        }
        return null;
    }*/

    @JsonValue
    public String getStatusName() {
        return this.statusName;
    }
}
