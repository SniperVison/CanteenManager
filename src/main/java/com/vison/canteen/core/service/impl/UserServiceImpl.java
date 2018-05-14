package com.vison.canteen.core.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vison.canteen.biz.common.BaseServiceImpl;
import com.vison.canteen.biz.enums.UserRole;
import com.vison.canteen.biz.util.BeanUtil;
import com.vison.canteen.biz.util.LongUtils;
import com.vison.canteen.core.bean.DTO.UserDTO;
import com.vison.canteen.core.bean.DTO.UserInfoDTO;
import com.vison.canteen.core.bean.PO.RolePO;
import com.vison.canteen.core.bean.PO.UserInfoPO;
import com.vison.canteen.core.bean.PO.UserPO;
import com.vison.canteen.core.bean.VO.UserVO;
import com.vison.canteen.core.exception.CanteenException;
import com.vison.canteen.core.mapper.UserMapper;
import com.vison.canteen.core.service.RoleService;
import com.vison.canteen.core.service.UserInfoService;
import com.vison.canteen.core.service.UserRoleService;
import com.vison.canteen.core.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author huangwenshen 2018/3/31 16:51
 */
@Slf4j
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<UserMapper, UserPO> implements UserService {

    @Value("${tmpLocation}")
    private String tmpLocation;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 通过用户名查询用户
     *
     * @param username
     * @return
     */
    @Override
    public UserPO getByUsername(String username) {
        return baseMapper.getByUsername(username);
    }

    @Override
    public List<RolePO> getRoleListById(Long userId) {
        List<Long> roleIds = userRoleService.selectRoleListByUserId(userId);
        List<RolePO> rolePOList = roleService.selectRoleListByIds(roleIds);
        return rolePOList;
    }

    @Override
    public List<UserVO> getAllUser() {
        List<UserPO> userPOList = baseMapper.getAllUser();
        log.error("" + userPOList);
        List<UserVO> userVOList = userPOList.parallelStream().map(e -> {
            UserVO userVO = new UserVO();
            BeanUtil.copyProperties(e, userVO);
            userVO.setId(LongUtils.LongToString(e.getId()));
            userVO.setUserRole(UserRole.ADMIN);
            userVO.setCard(e.getCard().toString());
            userVO.setCreateTime(e.getCreateTime());
            return userVO;
        }).collect(Collectors.toList());
        return userVOList;
    }

    @Override
    public Long addUser(UserPO userPO) {

        super.insert(userPO);
        return userPO.getId();
    }

    @Override
    public Boolean updateLoginTime(String username) {
        EntityWrapper<UserPO> ew = new EntityWrapper<>();
        ew.where("username = {0}", username);
        UserPO userPO = super.selectOne(ew);
        userPO.setLastLoginTime(new Date());
        return super.updateById(userPO);
    }

    @Override
    public Integer getUserCount() {
        return baseMapper.getUserCount();
    }

    @Override
    public UserVO getUserById(Long id) {
        UserPO userPO = baseMapper.selectById(id);
        UserVO userVO = new UserVO();
        BeanUtil.copyProperties(userPO, userVO);
        userVO.setId(id.toString());
        userVO.setUserRole(UserRole.ADMIN);
        return userVO;
    }

    @Override
    public Boolean updateUserById(UserDTO userDTO) throws CanteenException {
        if (userDTO == null) {
            throw CanteenException.USERDTO_NULL_EXCEPTION;
        }
        Long id = LongUtils.StringToLong(userDTO.getId());
        UserPO userPO = baseMapper.selectById(id);
        BeanUtils.copyProperties(userDTO, userPO);
        return super.updateById(userPO);
    }

    @Override
    public Boolean deleteUserById(Long id) {
        return super.deleteById(id);
    }

    @Override
    public Boolean deleteUserByIds(List<Long> idList) {
        return super.deleteBatchIds(idList);
    }

    @Override
    public byte[] getAvatarByUser(UserPO user) throws IOException {
        String filePath = tmpLocation + "\\" + user.getUsername();
        File file = new File(filePath, user.getAvatarUrl());
        FileInputStream inputStream = new FileInputStream(file);
        int i = inputStream.available();
        byte[] buff = new byte[i];
        inputStream.read(buff);
        inputStream.close();
        return buff;
    }

    @Override
    public Boolean updateUserInfo(UserInfoDTO userInfoDTO) {
        String username = userInfoDTO.getUsername();
        UserPO userPO = baseMapper.getByUsername(username);
        Long userId = userPO.getId();
        BeanUtil.copyProperties(userInfoDTO, userPO);
        super.updateById(userPO);
        UserInfoPO userInfoPO = userInfoService.getUserInfoByUserId(userId);
        if (userInfoPO == null) {
            userInfoPO = new UserInfoPO();
            BeanUtil.copyProperties(userInfoDTO, userInfoPO);
            userInfoPO.setUserId(userId);
            return userInfoService.insert(userInfoPO);
        } else {
            BeanUtil.copyProperties(userInfoDTO, userInfoPO);
            return userInfoService.updateById(userInfoPO);
        }
    }

}
