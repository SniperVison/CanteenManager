package com.vison.canteen.core.service.impl;

import com.vison.canteen.biz.common.BaseServiceImpl;
import com.vison.canteen.biz.util.BeanUtil;
import com.vison.canteen.biz.util.LongUtils;
import com.vison.canteen.core.bean.DTO.VegetableDTO;
import com.vison.canteen.core.bean.PO.VegetablePO;
import com.vison.canteen.core.bean.VO.VegetableVO;
import com.vison.canteen.core.mapper.VegetableMapper;
import com.vison.canteen.core.service.VegetableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author huangwenshen 2018/5/12 15:56
 */
@Slf4j
@Service
@Transactional
public class VegetableServiceImpl extends BaseServiceImpl<VegetableMapper, VegetablePO> implements VegetableService {
    @Override
    public Boolean addVegetable(VegetableDTO vegetableDTO) {
        VegetablePO vegetablePO = new VegetablePO();
        BeanUtil.copyProperties(vegetableDTO, vegetablePO);
        vegetablePO.setId(null);
        return super.insert(vegetablePO);
    }

    @Override
    public List<VegetableVO> getAllVegetable() {
        List<VegetablePO> vegetablePOList = baseMapper.getAllVegetable();
        List<VegetableVO> vegetableVOList = vegetablePOList.parallelStream().map(e -> {
            VegetableVO vegetableVO = new VegetableVO();
            BeanUtil.copyProperties(e, vegetableVO);
            vegetableVO.setId(e.getId().toString());
            return vegetableVO;
        }).collect(Collectors.toList());
        return vegetableVOList;
    }

    @Override
    public VegetablePO checkVegetableName(String name) {
        return baseMapper.checkVegetableName(name);
    }

    @Override
    public Boolean deleteVegetableById(String id) {
        Long vegetableId = LongUtils.StringToLong(id);
        return super.deleteById(vegetableId);
    }

    @Override
    public Boolean updateVegetableById(VegetableDTO vegetableDTO) {
        Long id = LongUtils.StringToLong(vegetableDTO.getId());
        VegetablePO vegetablePO = baseMapper.selectById(id);
        BeanUtil.copyProperties(vegetableDTO, vegetablePO);
        return super.updateById(vegetablePO);
    }

    @Override
    public Boolean deleteVegetableByIds(List<Long> idList) {
        return super.deleteBatchIds(idList);
    }

    @Override
    public Integer getLeft() {
        return baseMapper.getLeft();
    }

}
