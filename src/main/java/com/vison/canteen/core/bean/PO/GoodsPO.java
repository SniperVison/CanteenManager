package com.vison.canteen.core.bean.PO;

import com.baomidou.mybatisplus.annotations.TableName;
import com.vison.canteen.biz.bean.BasePO;
import lombok.Data;

/**
 * @author huangwenshen 2018/5/13 10:43
 */
@Data
@TableName("goods_info")
public class GoodsPO extends BasePO<GoodsPO> {

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
