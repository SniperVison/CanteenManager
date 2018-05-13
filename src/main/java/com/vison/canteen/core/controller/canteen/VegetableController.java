package com.vison.canteen.core.controller.canteen;

import com.vison.canteen.biz.util.LongUtils;
import com.vison.canteen.core.bean.DTO.VegetableDTO;
import com.vison.canteen.core.bean.PO.VegetablePO;
import com.vison.canteen.core.bean.VO.VegetableVO;
import com.vison.canteen.core.bean.PO.UserPO;
import com.vison.canteen.core.service.VegetableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author huangwenshen 2018/5/12 15:51
 */
@Slf4j
@RestController
@RequestMapping("vegetable")
public class VegetableController {

    @Autowired
    VegetableService vegetableService;

    @GetMapping("/")
    public ModelAndView vegetableView(HttpServletRequest request, HttpServletResponse response) {
        UserPO user = (UserPO) request.getSession().getAttribute("user");
        request.setAttribute("user", user);
        ModelAndView model = new ModelAndView();
        model.setViewName("vegetable");
        return model;
    }


    @PostMapping("get-all-vegetable")
    public List<VegetableVO> getAllVegetable() {
        return vegetableService.getAllVegetable();
    }

    @PostMapping("add")
    public Boolean addVegetable(@RequestBody VegetableDTO vegetableDTO) {
        return vegetableService.addVegetable(vegetableDTO);
    }

    @PostMapping("check-vegetable-name")
    public Boolean checkVegetableName(@RequestParam("name") String name) {
        VegetablePO vegetablePO = vegetableService.checkVegetableName(name);
        if (vegetablePO == null) {
            return true;
        } else {
            return false;
        }
    }

    @PostMapping("delete-vegetable-by-id")
    public Boolean deleteVegetableById(String id) {
        return vegetableService.deleteVegetableById(id);
    }

    @PostMapping("update-vegetable")
    public Boolean updateVegetable(@RequestBody VegetableDTO vegetableDTO) {
        return vegetableService.updateVegetableById(vegetableDTO);
    }

    @PostMapping("delete-vegetable-by-ids")
    public Boolean deleteVegetableByIds(@RequestBody List<String> ids) {
        List<Long> idList = ids.parallelStream().map(e -> LongUtils.StringToLong(e)).collect(Collectors.toList());
        return vegetableService.deleteVegetableByIds(idList);
    }


}
