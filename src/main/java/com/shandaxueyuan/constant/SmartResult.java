package com.shandaxueyuan.constant;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by HouRuidong on 2016/7/20.
 */
@Component
public class SmartResult<T> implements Serializable{


    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
