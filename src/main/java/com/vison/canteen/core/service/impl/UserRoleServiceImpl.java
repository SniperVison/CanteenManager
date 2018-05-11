package com.vison.canteen.core.service.impl;

import com.vison.canteen.biz.common.BaseServiceImpl;
import com.vison.canteen.core.bean.PO.UserRolePO;
import com.vison.canteen.core.mapper.UserRoleMapper;
import com.vison.canteen.core.service.RoleService;
import com.vison.canteen.core.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author huangwenshen 2018/3/31 16:59
 */
@Service
@Transactional
public class UserRoleServiceImpl extends BaseServiceImpl<UserRoleMapper, UserRolePO> implements UserRoleService {

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RoleService roleService;

    /**
     * 通过用户id查询角色id集合
     *
     * @param userId
     * @return
     */
    @Override
    public List<Long> selectRoleListByUserId(Long userId) {
        return baseMapper.selectRoleListByUserId(userId);
    }

}
