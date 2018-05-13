package com.vison.canteen.core.bean.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vison.canteen.biz.bean.BaseVO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

/**
 * @author huangwenshen 2018/5/13 10:43
 */
@Data
@ApiModel("杂货对象VO")
public class GoodsVO extends BaseVO {
    /**
     * 名称
     */
    private String name;

    /**
     * 单位
     */
    private String unit;

    /**
     * 数量
     */
    private Integer stock;

    /**
     * 单价
     */
    private Double price;

    /**
     * 保质期
     */
    private Integer shelfLife;

    /**
     * 批发商
     */
    private String wholeSaler;

    /**
     * 处理人
     */
    private String updator;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date modifyTime;
}
