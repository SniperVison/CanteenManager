package com.vison.canteen.biz.exception;

/**
 * @author huangwenshen 2018/4/4 23:48
 */
public class CommonException extends Exception {
    int code;

    public CommonException() {
        super("canteen exception ");
    }

    public CommonException(String msg) {
        super(msg);
        this.code = 500;
    }

    public CommonException(int code, String msg) {
        this(msg);
        this.code = code;
    }

    public CommonException(int code, String template, Object... input) {
        this(code, String.format(template, input));
    }

    public CommonException(CommonException.CommonOutput commonOutput) {
        this(commonOutput.getCode(), commonOutput.getMsg());
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public interface CommonOutput {
        int getCode();

        String getMsg();
    }
}
