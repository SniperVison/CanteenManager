package com.vison.canteen.core.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vison.canteen.core.bean.PO.PermissionInitPO;

import java.util.List;

/**
 * @author huangwenshen 2018/4/12 17:03
 */
public interface PermissionInitMapper extends BaseMapper<PermissionInitPO> {

    List<PermissionInitPO> selectAll();

}
