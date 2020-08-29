package com.guet.wushu.entity.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.nashorn.internal.objects.NativeUint8Array;

import java.io.Serializable;

/**
 * @ClassName JsonData
 * @Author asus
 * @Version 1.0
 * 发送给前端的JSON数据封装类
 */
public class JsonData implements Serializable {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * json数据
     */
    private Object data;

    /**
     * 信息
     */
    private String msg;

    public JsonData() {

    }

    public JsonData(Integer code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static JsonData buildSuccess(Object data){
        return new JsonData(0, data, null);
    }

    public static JsonData buildSuccess(Object data,String msg){
        return new JsonData(0,data,msg);
    }

    public static JsonData buildSuccess(int code,Object data,String msg){
        return new JsonData(code, data, msg);
    }

    public static JsonData buildError(String msg){
        return new JsonData(-1, null, msg);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "JsonData{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
