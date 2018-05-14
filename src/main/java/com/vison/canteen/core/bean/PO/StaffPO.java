package com.vison.canteen.core.bean.PO;

import com.baomidou.mybatisplus.annotations.TableName;
import com.vison.canteen.biz.bean.BasePO;
import lombok.Data;

import java.util.Date;

/**
 * @author huangwenshen 2018/5/13 17:35
 */
@Data
@TableName("staff_info")
public class StaffPO extends BasePO<StaffPO> {

    /**
     * 名称
     */
    private String name;

    /**
     * 工号
     */
    private Long workNumber;
    /**
     * 出生年月
     */
    private Date birthday;
    /**
     * 就职时间
     */
    private Date induction;
    /**
     * 工作单位
     */
    private String workUnit;
    /**
     * 工作岗位
     */
    private String position;

}
