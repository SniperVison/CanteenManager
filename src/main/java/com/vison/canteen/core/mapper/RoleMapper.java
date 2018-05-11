package com.vison.canteen.core.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vison.canteen.core.bean.PO.RolePO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author huangwenshen 2018/3/31 17:27
 */
public interface RoleMapper extends BaseMapper<RolePO> {

    List<RolePO> selectRoleListByIds(@Param("roleIds") List<Long> roleIds);

    List<RolePO> getAllRole();

}
