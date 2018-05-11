package com.vison.canteen.core.bean.PO;

import com.baomidou.mybatisplus.annotations.TableName;
import com.vison.canteen.biz.bean.BasePO;
import lombok.Data;

/**
 * 用户个人资料对象
 *
 * @author huangwenshen 2018/5/10 10:14
 */
@Data
@TableName("user_info")
public class UserInfoPO extends BasePO<UserInfoPO> {

    private Long userId;

    private String college;

    private String profession;

    private String classes;

    private String phone;

    private String content;

}
