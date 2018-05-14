package com.vison.canteen.core.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vison.canteen.core.bean.PO.StaffPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author huangwenshen 2018/5/13 18:31
 */
public interface StaffMapper extends BaseMapper<StaffPO> {

    List<StaffPO> getAllStaff();

    StaffPO checkStaffName(@Param("name") String name);

    StaffPO checkStaffworkNumber(@Param("workNumber") Long workNumber);

}
