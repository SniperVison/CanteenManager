package com.vison.canteen.core.service;

import com.baomidou.mybatisplus.service.IService;
import com.vison.canteen.core.bean.PO.CollegePO;

/**
 * @author huangwenshen 2018/3/10 18:19
 */
public interface CollegeService extends IService<CollegePO> {

    CollegePO getById(Long id);

    Boolean add(CollegePO collegePO);
}
