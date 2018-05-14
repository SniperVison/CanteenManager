package com.vison.canteen.biz.enums;

import com.baomidou.mybatisplus.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.io.Serializable;

/**
 * @author huangwenshen 2018/5/14 17:38
 */
@Getter
public enum ComsumeStatus implements IEnum {
    DEPOSIT(0, "存款"), COMSUME(1, "消费");

    private int type;

    private String typeName;

    ComsumeStatus(int type, String typeName) {
        this.type = type;
        this.typeName = typeName;
    }

    @Override
    public Serializable getValue() {
        return this.type;
    }

    @JsonValue
    public String getTypeName() {
        return typeName;
    }

}
