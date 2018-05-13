package com.vison.canteen.core.controller.canteen;

import com.vison.canteen.biz.util.LongUtils;
import com.vison.canteen.core.bean.DTO.MeatDTO;
import com.vison.canteen.core.bean.PO.MeatPO;
import com.vison.canteen.core.bean.PO.UserPO;
import com.vison.canteen.core.bean.VO.MeatVO;
import com.vison.canteen.core.service.MeatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author huangwenshen 2018/5/13 10:23
 */
@Slf4j
@RestController
@RequestMapping("meat")
public class MeatController {

    @Autowired
    MeatService meatService;

    @GetMapping("/")
    public ModelAndView meatView(HttpServletRequest request, HttpServletResponse response) {
        UserPO user = (UserPO) request.getSession().getAttribute("user");
        request.setAttribute("user", user);
        ModelAndView model = new ModelAndView();
        model.setViewName("meat");
        return model;
    }

    @PostMapping("get-all-meat")
    public List<MeatVO> getAllMeat() {
        return meatService.getAllMeat();
    }

    @PostMapping("add")
    public Boolean addMeat(@RequestBody MeatDTO meatDTO) {
        return meatService.addMeat(meatDTO);
    }

    @PostMapping("check-meat-name")
    public Boolean checkMeatName(@RequestParam("name") String name) {
        MeatPO meatPO = meatService.checkMeatName(name);
        if (meatPO == null) {
            return true;
        } else {
            return false;
        }
    }

    @PostMapping("delete-meat-by-id")
    public Boolean deleteMeatById(String id) {
        return meatService.deleteMeatById(id);
    }

    @PostMapping("update-meat")
    public Boolean updateMeat(@RequestBody MeatDTO meatDTO) {
        return meatService.updateMeatById(meatDTO);
    }

    @PostMapping("delete-meat-by-ids")
    public Boolean deleteMeatByIds(@RequestBody List<String> ids) {
        List<Long> idList = ids.parallelStream().map(e -> LongUtils.StringToLong(e)).collect(Collectors.toList());
        return meatService.deleteMeatByIds(idList);
    }

}
