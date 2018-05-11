package com.vison.canteen.core.bean.DTO;

import com.vison.canteen.biz.enums.UserRole;
import com.vison.canteen.biz.enums.UserStatus;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author huangwenshen 2018/5/8 9:11
 */
@ApiModel("用户对象DTO")
@Data
public class UserDTO {

    private String id;

    private String username;

    private String name;

    private String email;

    private UserStatus status;

    private UserRole userRole;

}
