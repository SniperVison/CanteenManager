package com.vison.canteen.core.service;

import com.baomidou.mybatisplus.service.IService;
import com.vison.canteen.core.bean.DTO.MeatDTO;
import com.vison.canteen.core.bean.PO.MeatPO;
import com.vison.canteen.core.bean.VO.MeatVO;

import java.util.List;

/**
 * @author huangwenshen 2018/5/13 10:24
 */
public interface MeatService extends IService<MeatPO> {

    List<MeatVO> getAllMeat();

    Boolean addMeat(MeatDTO meatDTO);

    MeatPO checkMeatName(String name);

    Boolean deleteMeatById(String id);

    Boolean updateMeatById(MeatDTO meatDTO);

    Boolean deleteMeatByIds(List<Long> idList);

    Integer getLeft();
}
