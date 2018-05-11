package com.vison.canteen.core.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vison.canteen.core.bean.PO.UserPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author huangwenshen 2018/3/31 16:52
 */
public interface UserMapper extends BaseMapper<UserPO> {
    /**
     * 通过用户名查询用户
     *
     * @param username
     * @return
     */
    UserPO getByUsername(@Param("username") String username);

    List<UserPO> getAllUser();

    Integer getUserCount();

}
