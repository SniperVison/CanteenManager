package com.vison.canteen.core.service;

import com.baomidou.mybatisplus.service.IService;
import com.vison.canteen.core.bean.DTO.UserDTO;
import com.vison.canteen.core.bean.DTO.UserInfoDTO;
import com.vison.canteen.core.bean.PO.RolePO;
import com.vison.canteen.core.bean.PO.UserPO;
import com.vison.canteen.core.bean.VO.UserVO;
import com.vison.canteen.core.exception.CanteenException;

import java.io.IOException;
import java.util.List;

/**
 * @author huangwenshen 2018/3/31 16:51
 */
public interface UserService extends IService<UserPO> {
    /**
     * 通过用户名查询用户
     *
     * @param username
     * @return
     */
    UserPO getByUsername(String username);

    /**
     * 通过用户id查询角色列表
     *
     * @param userId
     * @return
     */
    List<RolePO> getRoleListById(Long userId);


    List<UserVO> getAllUser();

    Long addUser(UserPO userPO);

    Boolean updateLoginTime(String username);

    Integer getUserCount();

    UserVO getUserById(Long id);

    Boolean updateUserById(UserDTO userDTO) throws CanteenException;

    Boolean deleteUserById(Long id);

    Boolean deleteUserByIds(List<Long> idList);

    byte[] getAvatarByUser(UserPO user) throws IOException;

    Boolean updateUserInfo(UserInfoDTO userInfoDTO);

}
