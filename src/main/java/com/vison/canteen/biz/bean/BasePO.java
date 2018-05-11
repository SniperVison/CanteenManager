package com.vison.canteen.biz.bean;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huangwenshen 2018/3/10 15:41
 */
@Data
public abstract class BasePO<T extends Model> extends Model<T> {

    @TableId(type = IdType.INPUT)
    protected Long id;

    /**
     * 创建日期
     */
    protected Date createTime;
    /**
     * 修改日期
     */
    protected Date modifyTime;

    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
