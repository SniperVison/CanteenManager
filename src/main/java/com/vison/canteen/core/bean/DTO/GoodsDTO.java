package com.vison.canteen.core.bean.DTO;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author huangwenshen 2018/5/13 10:44
 */
@Data
@ApiModel("杂货对象DTO")
public class GoodsDTO {

    private String id;

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
}
