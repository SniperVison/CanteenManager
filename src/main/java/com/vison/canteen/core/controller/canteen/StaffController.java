package com.vison.canteen.core.controller.canteen;

import com.vison.canteen.biz.util.LongUtils;
import com.vison.canteen.core.bean.DTO.StaffDTO;
import com.vison.canteen.core.bean.PO.StaffPO;
import com.vison.canteen.core.bean.PO.UserPO;
import com.vison.canteen.core.bean.VO.StaffVO;
import com.vison.canteen.core.service.StaffService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author huangwenshen 2018/5/13 18:29
 */
@Slf4j
@RestController
@RequestMapping("staff")
public class StaffController {

    @Autowired
    StaffService staffService;

    @GetMapping("/")
    public ModelAndView staffView(HttpServletRequest request, HttpServletResponse response) {
        UserPO user = (UserPO) request.getSession().getAttribute("user");
        request.setAttribute("user", user);
        ModelAndView model = new ModelAndView();
        model.setViewName("staff");
        return model;
    }

    @PostMapping("get-all-staff")
    public List<StaffVO> getAllStaff() {
        return staffService.getAllStaff();
    }

    @PostMapping("add")
    public Boolean addStaff(@RequestBody StaffDTO staffDTO) {
        return staffService.addStaff(staffDTO);
    }

    @PostMapping("check-staff-name")
    public Boolean checkStaffName(@RequestParam("name") String name) {
        StaffPO staffPO = staffService.checkStaffName(name);
        if (staffPO == null) {
            return true;
        } else {
            return false;
        }
    }

    @PostMapping("check-staff-worknumber")
    public Boolean checkStaffWorkNumber(@RequestParam("workNumber") Long workNumber) {
        StaffPO staffPO = staffService.checkStaffworkNumber(workNumber);
        if (staffPO == null) {
            return true;
        } else {
            return false;
        }
    }

    @PostMapping("delete-staff-by-id")
    public Boolean deleteStaffById(String id) {
        return staffService.deleteStaffById(id);
    }

    @PostMapping("update-staff")
    public Boolean updateStaff(@RequestBody StaffDTO staffDTO) {
        return staffService.updateStaffById(staffDTO);
    }

    @PostMapping("delete-staff-by-ids")
    public Boolean deleteStaffByIds(@RequestBody List<String> ids) {
        List<Long> idList = ids.parallelStream().map(e -> LongUtils.StringToLong(e)).collect(Collectors.toList());
        return staffService.deleteStaffByIds(idList);
    }

}
