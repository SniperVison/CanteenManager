package com.vison.canteen.core.service;

import com.baomidou.mybatisplus.service.IService;
import com.vison.canteen.core.bean.DTO.ComsumeDTO;
import com.vison.canteen.core.bean.PO.ComsumePO;
import com.vison.canteen.core.bean.VO.ComsumeVO;

import java.util.List;

/**
 * @author huangwenshen 2018/5/14 18:23
 */

public interface ComsumeService extends IService<ComsumePO> {

    List<ComsumeVO> getAllComsume();

    List<ComsumeVO> getComsumeByCard(Long card);

    Boolean addComsume(ComsumeDTO comsumeDTO);

    Boolean deleteComsumeById(String id);

    Boolean updateComsumeById(ComsumeDTO comsumeDTO);

    Boolean deleteComsumeByIds(List<Long> idList);

}
