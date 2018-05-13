package com.vison.canteen.core.service.impl;

import com.vison.canteen.biz.common.BaseServiceImpl;
import com.vison.canteen.biz.util.BeanUtil;
import com.vison.canteen.biz.util.LongUtils;
import com.vison.canteen.core.bean.DTO.GoodsDTO;
import com.vison.canteen.core.bean.PO.GoodsPO;
import com.vison.canteen.core.bean.VO.GoodsVO;
import com.vison.canteen.core.mapper.GoodsMapper;
import com.vison.canteen.core.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author huangwenshen 2018/5/13 10:57
 */
@Slf4j
@Service
@Transactional
public class GoodsServiceImpl extends BaseServiceImpl<GoodsMapper, GoodsPO> implements GoodsService {

    @Override
    public Boolean addGoods(GoodsDTO goodsDTO) {
        GoodsPO goodsPO = new GoodsPO();
        BeanUtil.copyProperties(goodsDTO, goodsPO);
        goodsPO.setId(null);
        return super.insert(goodsPO);
    }

    @Override
    public List<GoodsVO> getAllGoods() {
        List<GoodsPO> goodsPOList = baseMapper.getAllGoods();
        List<GoodsVO> goodsVOList = goodsPOList.parallelStream().map(e -> {
            GoodsVO goodsVO = new GoodsVO();
            BeanUtil.copyProperties(e,goodsVO);
            goodsVO.setId(e.getId().toString());
            return goodsVO;
        }).collect(Collectors.toList());
        return goodsVOList;
    }

    @Override
    public GoodsPO checkGoodsName(String name) {
        return baseMapper.checkGoodsName(name);
    }

    @Override
    public Boolean deleteGoodsById(String id) {
        Long goodsId = LongUtils.StringToLong(id);
        return super.deleteById(goodsId);
    }

    @Override
    public Boolean updateGoodsById(GoodsDTO goodsDTO) {
        Long id = LongUtils.StringToLong(goodsDTO.getId());
        GoodsPO goodsPO = baseMapper.selectById(id);
        BeanUtil.copyProperties(goodsDTO, goodsPO);
        return super.updateById(goodsPO);
    }

    @Override
    public Boolean deleteGoodsByIds(List<Long> idList) {
        return super.deleteBatchIds(idList);
    }
}
