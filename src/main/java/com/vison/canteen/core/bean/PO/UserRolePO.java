package com.vison.canteen.core.bean.PO;

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
    private Long userInfoId;
    /**
     * 角色id
     */
    private Long roleId;

}
