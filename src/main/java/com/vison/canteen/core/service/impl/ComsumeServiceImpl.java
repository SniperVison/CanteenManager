package com.vison.canteen.core.service.impl;

import com.vison.canteen.biz.common.BaseServiceImpl;
import com.vison.canteen.biz.util.BeanUtil;
import com.vison.canteen.biz.util.LongUtils;
import com.vison.canteen.core.bean.DTO.ComsumeDTO;
import com.vison.canteen.core.bean.PO.ComsumePO;
import com.vison.canteen.core.bean.VO.ComsumeVO;
import com.vison.canteen.core.mapper.ComsumeMapper;
import com.vison.canteen.core.service.ComsumeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author huangwenshen 2018/5/14 18:25
 */
@Slf4j
@Service
@Transactional
public class ComsumeServiceImpl extends BaseServiceImpl<ComsumeMapper, ComsumePO> implements ComsumeService {

    @Override
    public List<ComsumeVO> getAllComsume() {
        List<ComsumePO> comsumePOList = baseMapper.getAllComsume();
        List<ComsumeVO> comsumeVOList = comsumePOList.parallelStream().map(e -> {
            ComsumeVO comsumeVO = new ComsumeVO();
            BeanUtil.copyProperties(e, comsumeVO);
            comsumeVO.setId(e.getId().toString());
            comsumeVO.setCard(e.getCard().toString());
            return comsumeVO;
        }).collect(Collectors.toList());
        return comsumeVOList;
    }

    @Override
    public List<ComsumeVO> getComsumeByCard(Long card) {
        List<ComsumePO> comsumePOList = baseMapper.getComsumeByCard(card);
        List<ComsumeVO> comsumeVOList = comsumePOList.parallelStream().map(e -> {
            ComsumeVO comsumeVO = new ComsumeVO();
            BeanUtil.copyProperties(e, comsumeVO);
            comsumeVO.setId(e.getId().toString());
            comsumeVO.setCard(e.getCard().toString());
            return comsumeVO;
        }).collect(Collectors.toList());
        return comsumeVOList;
    }

    @Override
    public Boolean addComsume(ComsumeDTO comsumeDTO) {
        ComsumePO comsumePO = new ComsumePO();
        BeanUtil.copyProperties(comsumeDTO, comsumePO);
        comsumePO.setCard(LongUtils.StringToLong(comsumeDTO.getCard()));
        comsumePO.setId(null);
        return super.insert(comsumePO);
    }

    @Override
    public Boolean deleteComsumeById(String id) {
        Long comsumeId = LongUtils.StringToLong(id);
        return super.deleteById(comsumeId);
    }

    @Override
    public Boolean updateComsumeById(ComsumeDTO comsumeDTO) {
        Long comsumeId = LongUtils.StringToLong(comsumeDTO.getId());
        ComsumePO comsumePO = baseMapper.selectById(comsumeId);
        BeanUtil.copyProperties(comsumeDTO, comsumePO);
        comsumePO.setCard(LongUtils.StringToLong(comsumeDTO.getCard()));
        return super.updateById(comsumePO);
    }

    @Override
    public Boolean deleteComsumeByIds(List<Long> idList) {
        return super.deleteBatchIds(idList);
    }
}
