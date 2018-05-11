package com.vison.canteen.core.exception;

import com.vison.canteen.biz.exception.CommonException;

/**
 * @author huangwenshen 2018/4/4 23:47
 */
public class CanteenException extends CommonException {


    public CanteenException(int code, String msg) {
        super(code, msg);
    }

    public CanteenException(CommonOutput commonOutput) {
        super(commonOutput);
    }

    //角色类异常
    public static CanteenException ROLE_NULL_EXCEPTION = new CanteenException(CanteenOutput.ROLE_NULL);

    public static CanteenException ROLE_CANT_SET_ABLE_EXCEPTION = new CanteenException(CanteenOutput.ROLE_CANT_SET_ABLE);

    public static final CanteenException ROLE_NULL_ID_EXCEPTION = new CanteenException(CanteenOutput.ROLE_NULL_ID);

    public static final CanteenException ROLE_NULL_DATA_EXCEPTION = new CanteenException(CanteenOutput.ROLE_NULL_DATA);


    //用户类异常
    public static final CanteenException USER_INFO_UPDATE_FAILURE_EXCEPTION = new CanteenException(CanteenOutput.USER_INFO_UPDATE_FAILURE);

    public static final CanteenException USER_INFO_INSERT_DATA_FAILURE_EXCEPTION = new CanteenException(CanteenOutput.USER_INFO_INSERT_DATA_FAILURE);

    public static final CanteenException USERDTO_NULL_EXCEPTION = new CanteenException(CanteenOutput.USERDTO_NULL);
    //文件类异常
    public static final CanteenException FILE_NOT_FOUND_EXCEPTION = new CanteenException(CanteenOutput.FILE_NOT_FOUND);

    public static final CanteenException FILE_READING_ERROR_EXCEPTION = new CanteenException(CanteenOutput.FILE_READING_ERROR);

}
