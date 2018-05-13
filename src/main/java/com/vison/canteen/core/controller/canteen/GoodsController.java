package com.vison.canteen.core.controller.canteen;

import com.vison.canteen.biz.util.LongUtils;
import com.vison.canteen.core.bean.DTO.GoodsDTO;
import com.vison.canteen.core.bean.PO.GoodsPO;
import com.vison.canteen.core.bean.PO.UserPO;
import com.vison.canteen.core.bean.VO.GoodsVO;
import com.vison.canteen.core.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author huangwenshen 2018/5/13 10:47
 */
@Slf4j
@RestController
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @GetMapping("/")
    public ModelAndView goodsView(HttpServletRequest request, HttpServletResponse response) {
        UserPO user = (UserPO) request.getSession().getAttribute("user");
        request.setAttribute("user", user);
        ModelAndView model = new ModelAndView();
        model.setViewName("goods");
        return model;
    }

    @PostMapping("get-all-goods")
    public List<GoodsVO> getAllGoods() {
        return goodsService.getAllGoods();
    }

    @PostMapping("add")
    public Boolean addGoods(@RequestBody GoodsDTO goodsDTO) {
        return goodsService.addGoods(goodsDTO);
    }

    @PostMapping("check-goods-name")
    public Boolean checkGoodsName(@RequestParam("name") String name) {
        GoodsPO goodsPO = goodsService.checkGoodsName(name);
        if (goodsPO == null) {
            return true;
        } else {
            return false;
        }
    }

    @PostMapping("delete-goods-by-id")
    public Boolean deleteGoodsById(String id) {
        return goodsService.deleteGoodsById(id);
    }

    @PostMapping("update-goods")
    public Boolean updateGoods(@RequestBody GoodsDTO goodsDTO) {
        return goodsService.updateGoodsById(goodsDTO);
    }

    @PostMapping("delete-goods-by-ids")
    public Boolean deleteGoodsByIds(@RequestBody List<String> ids) {
        List<Long> idList = ids.parallelStream().map(e -> LongUtils.StringToLong(e)).collect(Collectors.toList());
        return goodsService.deleteGoodsByIds(idList);
    }
}
