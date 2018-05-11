package com.vison.canteen.core.service.impl;

import com.vison.canteen.biz.common.BaseServiceImpl;
import com.vison.canteen.core.bean.PO.UserInfoPO;
import com.vison.canteen.core.mapper.UserInfoMapper;
import com.vison.canteen.core.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author huangwenshen 2018/5/10 10:16
 */
@Slf4j
@Service
@Transactional
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfoMapper, UserInfoPO> implements UserInfoService {
    @Override
    public UserInfoPO getUserInfoByUserId(Long userId) {
        return baseMapper.getUserInfoByUserId(userId);
    }
}
