package com.vison.canteen.core.service;

import com.baomidou.mybatisplus.service.IService;
import com.vison.canteen.core.bean.DTO.GoodsDTO;
import com.vison.canteen.core.bean.PO.GoodsPO;
import com.vison.canteen.core.bean.VO.GoodsVO;

import java.util.List;

/**
 * @author huangwenshen 2018/5/13 10:55
 */

public interface GoodsService extends IService<GoodsPO> {

    List<GoodsVO> getAllGoods();

    Boolean addGoods(GoodsDTO goodsDTO);

   GoodsPO checkGoodsName(String name);

    Boolean deleteGoodsById(String id);

    Boolean updateGoodsById(GoodsDTO goodsDTO);

    Boolean deleteGoodsByIds(List<Long> idList);

}
