package com.vison.canteen.core.service.impl;

import com.vison.canteen.biz.common.BaseServiceImpl;
import com.vison.canteen.core.bean.PO.RolePermissionPO;
import com.vison.canteen.core.mapper.RolePermissionMapper;
import com.vison.canteen.core.service.RolePermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author huangwenshen 2018/3/31 16:59
 */
@Service
@Transactional
public class RolePermissionServiceImpl extends BaseServiceImpl<RolePermissionMapper, RolePermissionPO> implements RolePermissionService {
    @Override
    public List<Long> getPermissionIdsByRoleId(Long roleId) {
        return baseMapper.getPermissionIdsByRoleId(roleId);
    }
}
