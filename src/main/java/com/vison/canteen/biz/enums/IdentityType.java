package com.vison.canteen.biz.enums;

import com.baomidou.mybatisplus.enums.IEnum;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * @author huangwenshen 2018/3/10 22:17
 */
@Getter
public enum IdentityType implements IEnum {

    STUDENT(0, "学生"), STAFF(1, "学校职工");

    private int type;
    private String typeName;

    IdentityType(final int type, final String typeName) {
        this.type = type;
        this.typeName = typeName;
    }

    @Override
    public Serializable getValue() {
        return type;
    }

    public static IdentityType select(String typeName) {
        if (StringUtils.isBlank(typeName)) {
            return null;
        }
        for (IdentityType identityType : IdentityType.values()) {
            if (identityType.typeName.equals(typeName)) {
                return identityType;
            }
        }
        return null;
    }

}
