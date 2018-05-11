package com.vison.canteen.core.bean.PO;

import com.baomidou.mybatisplus.annotations.TableName;
import com.vison.canteen.biz.bean.BasePO;
import lombok.Data;

/**
 * @author huangwenshen 2018/4/12 16:52
 */
@Data
@TableName("sys_permission_init")
public class PermissionInitPO extends BasePO<PermissionInitPO> {
    /**
     * 链接地址
     */
    private String url;
    /**
     * 需要具备的权限
     */
    private String PermissionInit;
    /**
     * 排序
     */
    private Integer sort;

}
