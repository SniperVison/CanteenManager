package com.vison.canteen.core.service;

import com.baomidou.mybatisplus.service.IService;
import com.vison.canteen.core.bean.PO.UserInfoPO;

/**
 * @author huangwenshen 2018/5/10 10:16
 */
public interface UserInfoService extends IService<UserInfoPO> {

    UserInfoPO getUserInfoByUserId(Long userId);

}
