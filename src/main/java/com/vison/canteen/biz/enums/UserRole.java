package com.vison.canteen.biz.enums;

import com.baomidou.mybatisplus.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.io.Serializable;

/**
 * @author huangwenshen 2018/5/8 9:15
 */
@Getter
public enum UserRole implements IEnum {

    USER(0, "普通用户"), ADMIN(1, "管理员");

    private int type;
    private String typeName;

    @Override
    public Serializable getValue() {
        return this.type;
    }

    UserRole(int type, String typeName) {
        this.type = type;
        this.typeName = typeName;
    }

    @JsonValue
    public String getTypeName() {
        return typeName;
    }
}
