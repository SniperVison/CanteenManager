package com.vison.canteen.core.service;

import com.baomidou.mybatisplus.service.IService;
import com.vison.canteen.core.bean.PO.RolePermissionPO;

import java.util.List;

/**
 * @author huangwenshen 2018/3/31 16:56
 */
public interface RolePermissionService extends IService<RolePermissionPO> {

    List<Long> getPermissionIdsByRoleId(Long roleId);

}
