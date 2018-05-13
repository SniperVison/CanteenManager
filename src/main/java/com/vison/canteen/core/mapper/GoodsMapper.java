package com.vison.canteen.core.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vison.canteen.core.bean.PO.GoodsPO;

import java.util.List;

/**
 * @author huangwenshen 2018/5/13 10:58
 */
public interface GoodsMapper extends BaseMapper<GoodsPO> {

    List<GoodsPO> getAllGoods();

    GoodsPO checkGoodsName(String name);

}
