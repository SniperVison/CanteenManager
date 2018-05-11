package com.vison.canteen.core.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vison.canteen.core.bean.PO.RolePermissionPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author huangwenshen 2018/3/31 17:27
 */
public interface RolePermissionMapper extends BaseMapper<RolePermissionPO> {

    List<Long> getPermissionIdsByRoleId(@Param("roleId") Long roleId);

}
