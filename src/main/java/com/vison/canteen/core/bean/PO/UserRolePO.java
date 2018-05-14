package com.vison.canteen.core.bean.PO;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.vison.canteen.biz.bean.BasePO;
import lombok.Data;

/**
 * @author huangwenshen 2018/3/26 18:14
 */
@Data
@TableName("sys_user_role")
public class UserRolePO extends BasePO<UserRolePO> {
    /**
     * 用户id
     */
    @TableField("uid")
    private Long userId;
    /**
     * 角色id
     */
    @TableField("rid")
    private Long roleId;

}
