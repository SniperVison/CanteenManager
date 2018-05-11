package com.vison.canteen.core.service;

import com.baomidou.mybatisplus.service.IService;
import com.vison.canteen.core.bean.PO.UserRolePO;

import java.util.List;

/**
 * @author huangwenshen 2018/3/31 16:56
 */
public interface UserRoleService extends IService<UserRolePO> {

    List<Long> selectRoleListByUserId(Long userId);

}
