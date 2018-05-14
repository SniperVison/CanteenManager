package com.vison.canteen.core.bean.DTO;

import com.vison.canteen.biz.enums.ComsumeStatus;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author huangwenshen 2018/5/14 18:14
 */
@Data
@ApiModel("消费对象DTO")
public class ComsumeDTO {

    private String id;

    private String card;

    private Double money;

    private ComsumeStatus status;

}
