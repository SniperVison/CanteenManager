package com.vison.canteen.core.bean.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vison.canteen.biz.bean.BaseVO;
import com.vison.canteen.biz.enums.UserRole;
import com.vison.canteen.biz.enums.UserStatus;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

/**
 * @author huangwenshen 2018/5/3 22:14
 */
@Data
@ApiModel("用户对象VO")
public class UserVO extends BaseVO {

    //    @ApiModelProperty(example = "")
    private String username;

    private String name;

    private String email;

    private String card;

    private UserStatus status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastLoginTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private UserRole userRole;

}
