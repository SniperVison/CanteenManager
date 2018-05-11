package com.vison.canteen.core.bean.PO;

import com.baomidou.mybatisplus.annotations.TableName;
import com.vison.canteen.biz.bean.BasePO;
import com.vison.canteen.biz.enums.UserStatus;
import lombok.Data;

import java.util.Date;

/**
 * 用户信息类
 *
 * @author huangwenshen 2018/3/11 21:07
 */
@Data
@TableName("sys_user")
public class UserPO extends BasePO<UserPO> {

    /**
     * 账号
     */
    private String username;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 昵称或者名称
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 加密的盐
     */
    private String salt;
    /**
     * 状态(0代表创建未认证, 1代表正常状态， 2代表锁定状态)
     */
    private UserStatus status;
    /**
     * 最后登录状态
     */
    private Date lastLoginTime;

    /**
     * 头像url
     */
    private String avatarUrl;

}
