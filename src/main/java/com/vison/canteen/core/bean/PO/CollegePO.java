package com.vison.canteen.core.bean.PO;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.vison.canteen.biz.bean.BasePO;
import com.vison.canteen.biz.enums.IdentityType;
import lombok.Data;

/**
 * @author huangwenshen 2018/3/10 16:09
 */
@Data
@TableName("college")
public class CollegePO extends BasePO<CollegePO> {

    //TODO DTO起别名处理
    /**
     * 学院名称
     */
    @TableField("college_name")
    private String name;
    /**
     * 专业
     */
    private String profession;
    /**
     * 身份,  默认0是学生, 1是职工
     */
    private IdentityType identity;

}
