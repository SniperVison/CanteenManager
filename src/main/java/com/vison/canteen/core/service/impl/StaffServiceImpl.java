package com.vison.canteen.core.service.impl;

import com.vison.canteen.biz.common.BaseServiceImpl;
import com.vison.canteen.biz.util.BeanUtil;
import com.vison.canteen.biz.util.LongUtils;
import com.vison.canteen.core.bean.DTO.StaffDTO;
import com.vison.canteen.core.bean.PO.StaffPO;
import com.vison.canteen.core.bean.VO.StaffVO;
import com.vison.canteen.core.mapper.StaffMapper;
import com.vison.canteen.core.service.StaffService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author huangwenshen 2018/5/13 18:30
 */
@Slf4j
@Service
@Transactional
public class StaffServiceImpl extends BaseServiceImpl<StaffMapper, StaffPO> implements StaffService {

    @Override
    public List<StaffVO> getAllStaff() {
        List<StaffPO> staffPOList = baseMapper.getAllStaff();
        List<StaffVO> staffVOList = staffPOList.parallelStream().map(e -> {
            StaffVO staffVO = new StaffVO();
            BeanUtil.copyProperties(e, staffVO);
            staffVO.setId(e.getId().toString());
            return staffVO;
        }).collect(Collectors.toList());
        return staffVOList;
    }

    @Override
    public Boolean addStaff(StaffDTO staffDTO) {
        StaffPO staffPO = new StaffPO();
        BeanUtil.copyProperties(staffDTO, staffPO);
        staffPO.setId(null);
        return super.insert(staffPO);
    }

    @Override
    public StaffPO checkStaffName(String name) {
        return baseMapper.checkStaffName(name);
    }

    @Override
    public Boolean deleteStaffById(String id) {
        Long staffId = LongUtils.StringToLong(id);
        return super.deleteById(staffId);
    }

    @Override
    public Boolean updateStaffById(StaffDTO staffDTO) {
        Long id = LongUtils.StringToLong(staffDTO.getId());
        StaffPO staffPO = baseMapper.selectById(id);
        BeanUtil.copyProperties(staffDTO, staffPO);
        return super.updateById(staffPO);
    }

    @Override
    public Boolean deleteStaffByIds(List<Long> idList) {
        return super.deleteBatchIds(idList);
    }

    @Override
    public StaffPO checkStaffworkNumber(Long workNumber) {
        return baseMapper.checkStaffworkNumber(workNumber);
    }

}
