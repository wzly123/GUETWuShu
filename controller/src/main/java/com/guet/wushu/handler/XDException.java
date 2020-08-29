package com.guet.wushu.handler;

/**
 * @ClassName XDException
 * @Author asus
 * @Version 1.0
 * 自定义异常类
 */
public class XDException extends RuntimeException {

    /**
     * 出错代码
     */
    private Integer code;

    /**
     * 出错信息
     */
    private String msg;

    public XDException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
