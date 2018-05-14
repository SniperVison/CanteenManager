package com.vison.canteen.core.service;

import com.baomidou.mybatisplus.service.IService;
import com.vison.canteen.core.bean.DTO.VegetableDTO;
import com.vison.canteen.core.bean.PO.VegetablePO;
import com.vison.canteen.core.bean.VO.VegetableVO;

import java.util.List;

/**
 * @author huangwenshen 2018/5/12 15:55
 */
public interface VegetableService extends IService<VegetablePO> {

    Boolean addVegetable(VegetableDTO vegetableDTO);

    List<VegetableVO> getAllVegetable();

    VegetablePO checkVegetableName(String name);

    Boolean deleteVegetableById(String id);

    Boolean updateVegetableById(VegetableDTO vegetableDTO);

    Boolean deleteVegetableByIds(List<Long> idList);

    Integer getLeft();
}
