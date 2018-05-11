package com.vison.canteen.core.bean.PO;

import com.baomidou.mybatisplus.annotations.TableName;
import com.vison.canteen.biz.bean.BasePO;
import lombok.Data;

/**
 * 角色权限关系类
 *
 * @author huangwenshen 2018/3/26 18:12
 */
@Data
@TableName("sys_role_permission")
public class RolePermissionPO extends BasePO<RolePermissionPO> {
    /**
     * 权限id
     */
    private Long permissionId;
    /**
     * 角色id
     */
    private Long roleId;

}
