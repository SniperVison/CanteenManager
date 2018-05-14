package com.vison.canteen.core.service;

import com.baomidou.mybatisplus.service.IService;
import com.vison.canteen.core.bean.DTO.StaffDTO;
import com.vison.canteen.core.bean.PO.StaffPO;
import com.vison.canteen.core.bean.VO.StaffVO;

import java.util.List;

/**
 * @author huangwenshen 2018/5/13 18:30
 */
public interface StaffService extends IService<StaffPO> {

    List<StaffVO> getAllStaff();

    Boolean addStaff(StaffDTO staffDTO);

    StaffPO checkStaffName(String name);

    Boolean deleteStaffById(String id);

    Boolean updateStaffById(StaffDTO staffDTO);

    Boolean deleteStaffByIds(List<Long> idList);

    StaffPO checkStaffworkNumber(Long workNumber);

}
