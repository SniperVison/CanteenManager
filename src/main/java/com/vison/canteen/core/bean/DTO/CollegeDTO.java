package com.vison.canteen.core.bean.DTO;

import com.vison.canteen.biz.enums.IdentityType;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author huangwenshen 2018/3/10 23:08
 */
@Data
@ApiModel("个人学校信息对象DTO")
public class CollegeDTO {

    /**
     *
     */
    private String name;

    private String profession;

//    @JSONField(serialzeFeatures= SerializerFeature.WriteEnumUsingToString)
    private IdentityType identity;
}
