package com.vison.canteen.core.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vison.canteen.core.bean.PO.UserInfoPO;
import org.apache.ibatis.annotations.Param;

/**
 * @author huangwenshen 2018/5/10 10:17
 */
public interface UserInfoMapper extends BaseMapper<UserInfoPO> {

    UserInfoPO getUserInfoByUserId(@Param("userId") Long userId);

}
