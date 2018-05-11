package com.vison.canteen.core.bean.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author huangwenshen 2018/4/16 22:36
 */
@ApiModel("角色对象DTO")
@Data
public class RoleDTO {

    @ApiModelProperty(example = "id, string", value = "角色id")
    private String id;

    @ApiModelProperty(example = "name, string", value = "角色名称")
    private String name;

    @ApiModelProperty(example = "description,string", value = "角色描述")
    private String description;

    @ApiModelProperty(example = "able, boolean", value = "角色是否可用")
    private Boolean able;

}
