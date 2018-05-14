package com.vison.canteen.core.service.impl;

import com.vison.canteen.biz.common.BaseServiceImpl;
import com.vison.canteen.biz.util.BeanUtil;
import com.vison.canteen.biz.util.LongUtils;
import com.vison.canteen.core.bean.DTO.MeatDTO;
import com.vison.canteen.core.bean.PO.MeatPO;
import com.vison.canteen.core.bean.VO.MeatVO;
import com.vison.canteen.core.mapper.MeatMapper;
import com.vison.canteen.core.service.MeatService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author huangwenshen 2018/5/13 10:25
 */
@Service
@Transactional
public class MeatServiceImpl extends BaseServiceImpl<MeatMapper, MeatPO> implements MeatService {

    @Override
    public Boolean addMeat(MeatDTO meatDTO) {
        MeatPO meatPO = new MeatPO();
        BeanUtil.copyProperties(meatDTO, meatPO);
        meatPO.setId(null);
        return super.insert(meatPO);
    }

    @Override
    public List<MeatVO> getAllMeat() {
        List<MeatPO> meatPOList = baseMapper.getAllMeat();
        List<MeatVO> meatVOList = meatPOList.parallelStream().map(e -> {
            MeatVO meatVO = new MeatVO();
            BeanUtil.copyProperties(e, meatVO);
            meatVO.setId(e.getId().toString());
            return meatVO;
        }).collect(Collectors.toList());
        return meatVOList;
    }

    @Override
    public MeatPO checkMeatName(String name) {
        return baseMapper.checkMeatName(name);
    }

    @Override
    public Boolean deleteMeatById(String id) {
        Long meatId = LongUtils.StringToLong(id);
        return super.deleteById(meatId);
    }

    @Override
    public Boolean updateMeatById(MeatDTO meatDTO) {
        Long id = LongUtils.StringToLong(meatDTO.getId());
        MeatPO meatPO = baseMapper.selectById(id);
        BeanUtil.copyProperties(meatDTO, meatPO);
        return super.updateById(meatPO);
    }

    @Override
    public Boolean deleteMeatByIds(List<Long> idList) {
        return super.deleteBatchIds(idList);
    }

    @Override
    public Integer getLeft() {
        return baseMapper.getLeft();
    }

}
