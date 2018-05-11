package com.vison.canteen.core.service.impl;

import com.vison.canteen.biz.common.BaseServiceImpl;
import com.vison.canteen.core.bean.PO.PermissionInitPO;
import com.vison.canteen.core.mapper.PermissionInitMapper;
import com.vison.canteen.core.service.PermissionInitService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author huangwenshen 2018/4/12 17:01
 */
@Service
@Transactional
public class PermissionInitServiceImpl extends BaseServiceImpl<PermissionInitMapper, PermissionInitPO> implements PermissionInitService {
    @Override
    public List<PermissionInitPO> selectAll() {
        return baseMapper.selectAll();
    }
}
