package com.vison.canteen.core.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vison.canteen.core.bean.PO.VegetablePO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author huangwenshen 2018/5/12 15:57
 */
public interface VegetableMapper extends BaseMapper<VegetablePO> {

    List<VegetablePO> getAllVegetable();

    VegetablePO checkVegetableName(@Param("name") String name);

}
