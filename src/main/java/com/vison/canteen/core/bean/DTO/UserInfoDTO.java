package com.vison.canteen.core.bean.DTO;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author huangwenshen 2018/5/10 10:06
 */
@ApiModel("用户资料对象DTO")
@Data
public class UserInfoDTO {

    private String username;

    private String name;

    private String phone;

    private String email;

    private String content;

    private String college;

    private String profession;

    private String classes;

}
