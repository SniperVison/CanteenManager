package com.vison.canteen.core.bean.PO;

import com.baomidou.mybatisplus.annotations.TableName;
import com.vison.canteen.biz.bean.BasePO;
import lombok.Data;

/**
 * 蔬菜类
 *
 * @author huangwenshen 2018/5/12 11:24
 */
@Data
@TableName("vegetable_info")
public class VegetablePO extends BasePO<VegetablePO> {

    /**
     * 名称
     */
    private String name;

    /**
     * 单位
     */
    private String unit;

    /**
     * 库存
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
