package com.vison.canteen.core.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vison.canteen.core.bean.PO.ComsumePO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author huangwenshen 2018/5/14 18:25
 */
public interface ComsumeMapper extends BaseMapper<ComsumePO> {
    List<ComsumePO> getAllComsume();

    List<ComsumePO> getComsumeByCard(@Param("card") Long card);
}
