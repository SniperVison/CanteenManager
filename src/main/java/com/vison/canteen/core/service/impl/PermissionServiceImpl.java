package com.vison.canteen.core.service.impl;

import com.vison.canteen.biz.common.BaseServiceImpl;
import com.vison.canteen.core.bean.PO.PermissionPO;
import com.vison.canteen.core.mapper.PermissionMapper;
import com.vison.canteen.core.service.PermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author huangwenshen 2018/3/31 16:58
 */
@Service
@Transactional
public class PermissionServiceImpl extends BaseServiceImpl<PermissionMapper, PermissionPO> implements PermissionService {
}
