package com.vison.canteen.core.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vison.canteen.core.bean.PO.MeatPO;

import java.util.List;

/**
 * @author huangwenshen 2018/5/13 10:26
 */
public interface MeatMapper extends BaseMapper<MeatPO> {

    List<MeatPO> getAllMeat();

    MeatPO checkMeatName(String name);

}
