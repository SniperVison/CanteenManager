package com.vison.canteen.core.service;

import com.baomidou.mybatisplus.service.IService;
import com.vison.canteen.core.bean.DTO.RoleDTO;
import com.vison.canteen.core.bean.PO.PermissionPO;
import com.vison.canteen.core.bean.PO.RolePO;
import com.vison.canteen.core.bean.VO.RoleVO;
import com.vison.canteen.core.exception.CanteenException;

import java.util.List;

/**
 * @author huangwenshen 2018/3/31 16:56
 */
public interface RoleService extends IService<RolePO> {

    List<RolePO> selectRoleListByIds(List<Long> roleIds);

    List<PermissionPO> getPermissionListById(Long roleId);

    Boolean addRole(RoleDTO roleDTO) throws CanteenException;

    Boolean updateRole(RoleDTO roleDTO) throws CanteenException;

    Boolean deleteRoleById(Long id);

    Boolean deleteRoleByIds(List<Long> roleIds);

    List<RoleVO>getAllRole();

}
