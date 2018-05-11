package com.vison.canteen.core.bean.PO;

import com.baomidou.mybatisplus.annotations.TableName;
import com.vison.canteen.biz.bean.BasePO;
import lombok.Data;

/**
 * 权限类
 *
 * @author huangwenshen 2018/3/26 18:04
 */
@Data
@TableName("sys_permission")
public class PermissionPO extends BasePO<PermissionPO> {
    /**
     * 权限url
     */
    private String url;
    /**
     * 权限描述
     */
    private String description;

}
