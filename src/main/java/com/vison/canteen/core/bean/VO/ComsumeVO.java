package com.vison.canteen.core.bean.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vison.canteen.biz.bean.BaseVO;
import com.vison.canteen.biz.enums.ComsumeStatus;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

/**
 * @author huangwenshen 2018/5/14 18:14
 */
@Data
@ApiModel("消费对象VO")
public class ComsumeVO extends BaseVO {

    private String card;

    private Double money;

    private ComsumeStatus status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date modifyTime;

}
