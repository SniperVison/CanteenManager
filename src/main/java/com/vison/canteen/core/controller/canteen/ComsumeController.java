package com.vison.canteen.core.controller.canteen;

import com.vison.canteen.biz.util.LongUtils;
import com.vison.canteen.core.bean.DTO.ComsumeDTO;
import com.vison.canteen.core.bean.PO.UserPO;
import com.vison.canteen.core.bean.VO.ComsumeVO;
import com.vison.canteen.core.service.ComsumeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author huangwenshen 2018/5/14 18:15
 */
@Slf4j
@RestController
@RequestMapping("comsume")
public class ComsumeController {

    @Autowired
    ComsumeService comsumeService;

    @GetMapping("/")
    public ModelAndView comsumeView(HttpServletRequest request, HttpServletResponse response) {
        UserPO user = (UserPO) request.getSession().getAttribute("user");
        request.setAttribute("user", user);
        ModelAndView model = new ModelAndView();
        model.setViewName("comsume");
        return model;
    }

    @PostMapping("get-all-comsume")
    public List<ComsumeVO> getAllComsume() {
        return comsumeService.getAllComsume();
    }

    @PostMapping("get-comsume-by-card")
    public List<ComsumeVO> getComsumeByCard(HttpServletRequest request, HttpServletResponse response) {
        UserPO userPO = (UserPO) request.getSession().getAttribute("user");
        Long card = userPO.getCard();
        return comsumeService.getComsumeByCard(card);
    }

    @PostMapping("add")
    public Boolean addComsume(@RequestBody ComsumeDTO comsumeDTO) {
        return comsumeService.addComsume(comsumeDTO);
    }

    @PostMapping("delete-comsume-by-id")
    public Boolean deleteComsumeById(String id) {
        return comsumeService.deleteComsumeById(id);
    }

    @PostMapping("update-comsume")
    public Boolean updateComsume(@RequestBody ComsumeDTO comsumeDTO) {
        return comsumeService.updateComsumeById(comsumeDTO);
    }

    @PostMapping("delete-comsume-by-ids")
    public Boolean deleteComsumeByIds(@RequestBody List<String> ids) {
        List<Long> idList = ids.parallelStream().map(e -> LongUtils.StringToLong(e)).collect(Collectors.toList());
        return comsumeService.deleteComsumeByIds(idList);
    }


}
