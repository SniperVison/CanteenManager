package com.vison.canteen.core.bean.PO;

import com.baomidou.mybatisplus.annotations.TableName;
import com.vison.canteen.biz.bean.BasePO;
import com.vison.canteen.biz.enums.ComsumeStatus;
import lombok.Data;

/**
 * @author huangwenshen 2018/5/14 17:36
 */
@Data
@TableName("comsume_info")
public class ComsumePO extends BasePO<ComsumePO> {

    private Long card;

    private Double money;

    private ComsumeStatus status;


}
