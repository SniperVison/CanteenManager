package com.vison.canteen.core.service.impl;

import com.vison.canteen.biz.common.BaseServiceImpl;
import com.vison.canteen.core.bean.PO.CollegePO;
import com.vison.canteen.core.mapper.CollegeMapper;
import com.vison.canteen.core.service.CollegeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author huangwenshen 2018/3/10 18:20
 */

@Service
@Transactional
public class CollegeServiceImpl extends BaseServiceImpl<CollegeMapper,CollegePO> implements CollegeService {

    @Override
    public CollegePO getById(Long id){
        return baseMapper.selectById(id);
    }

    @Override
    public Boolean add(CollegePO collegePO) {
        return super.insert(collegePO);
    }
}
