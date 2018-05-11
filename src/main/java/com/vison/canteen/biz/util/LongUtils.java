package com.vison.canteen.biz.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Long转换String工具类
 * @author huangwenshen 2018/3/10 15:47
 */
public class LongUtils {

    private static final Logger logger = LoggerFactory.getLogger(LongUtils.class);

    /**
     * 将Long类型的id转换为String类型
     * @param id
     * @return
     */
    public static String LongToString(Long id){
        if(id != null){
            return id.toString();
        }else{
            logger.info("id为空");
            return null;
        }
    }

    /**
     * 将String类型的id转换为Long类型
     * @param id
     * @return
     */
    public static Long StringToLong(String id){
        if(id != null){
            return Long.parseLong(id);
        }else{
            logger.info("id为空");
            return null;
        }
    }
}
