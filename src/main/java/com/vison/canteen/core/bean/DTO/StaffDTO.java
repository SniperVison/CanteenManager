package com.vison.canteen.core.bean.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

/**
 * @author huangwenshen 2018/5/13 18:50
 */
@Data
@ApiModel("员工对象DTO")
public class StaffDTO {

    private String id;

    private String name;

    private Long workNumber;

    private String position;

    private String workUnit;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date induction;
}
