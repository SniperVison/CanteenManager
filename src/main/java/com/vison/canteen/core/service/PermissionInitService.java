package com.vison.canteen.core.service;

import com.baomidou.mybatisplus.service.IService;
import com.vison.canteen.core.bean.PO.PermissionInitPO;

import java.util.List;

/**
 * @author huangwenshen 2018/4/12 16:59
 */
public interface PermissionInitService extends IService<PermissionInitPO> {

    List<PermissionInitPO> selectAll();

}
