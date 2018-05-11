package com.vison.canteen.core.controller;

import com.vison.canteen.core.bean.DTO.CollegeDTO;
import com.vison.canteen.core.bean.PO.CollegePO;
import com.vison.canteen.core.service.CollegeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author huangwenshen 2018/3/10 16:14
 */
@RestController
@RequestMapping("college")
public class CollegeController {

    @Autowired
    CollegeService collegeService;

    @GetMapping("get/{id}")
    public CollegePO getById(@PathVariable Long id) {
        CollegePO collegePO = collegeService.getById(id);
        return collegePO;
    }

    @PostMapping("add")
    public Boolean add(@RequestBody CollegeDTO collegeDTO) {
        CollegePO collegePO = new CollegePO();
        BeanUtils.copyProperties(collegeDTO, collegePO);
        if (collegeService.add(collegePO)) {
            return true;
        }
        return false;
    }


}
