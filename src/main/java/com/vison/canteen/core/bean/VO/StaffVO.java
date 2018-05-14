package com.vison.canteen.core.bean.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vison.canteen.biz.bean.BaseVO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

/**
 * @author huangwenshen 2018/5/13 18:40
 */
@Data
@ApiModel("职工对象VO")
public class StaffVO extends BaseVO {

    private String name;

    private Long workNumber;

    private String position;

    private String workUnit;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date induction;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date modifyTime;

}


