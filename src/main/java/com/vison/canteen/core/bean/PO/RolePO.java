package com.vison.canteen.core.bean.PO;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.vison.canteen.biz.bean.BasePO;
import lombok.Data;

/**
 * 角色类
 *
 * @author huangwenshen 2018/3/26 18:06
 */
@Data
@TableName("sys_role")
public class RolePO extends BasePO<RolePO> {
    /**
     * 角色名称
     */
    private String role;
    /**
     * 角色描述
     */
    private String description;
    /**
     * 角色是否可用
     */
    @TableField("is_able")
    private Boolean able;

}

