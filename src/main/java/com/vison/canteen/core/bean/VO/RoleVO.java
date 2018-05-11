package com.vison.canteen.core.bean.VO;

import com.baomidou.mybatisplus.annotations.TableField;
import com.vison.canteen.biz.bean.BaseVO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author huangwenshen 2018/5/8 22:07
 */
@ApiModel("角色对象VO")
@Data
public class RoleVO extends BaseVO {
    /**
     * 角色名称
     */
    private String role;
    /**
     * 角色描述
     */
    private String description;
    /**
     * 角色是否可用
     */
    @TableField("is_able")
    private Boolean able;

}
