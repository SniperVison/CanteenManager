package com.vison.canteen.core.bean.DTO;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author huangwenshen 2018/5/12 15:58
 */
@Data
@ApiModel("蔬菜对象DTO")
public class VegetableDTO {

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
