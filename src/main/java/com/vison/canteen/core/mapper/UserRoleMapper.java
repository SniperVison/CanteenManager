package com.vison.canteen.core.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vison.canteen.core.bean.PO.UserRolePO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author huangwenshen 2018/3/31 17:28
 */
public interface UserRoleMapper extends BaseMapper<UserRolePO> {

    List<Long> selectRoleListByUserId(@Param("userId") Long userId);

}
