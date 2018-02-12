package com.example.springboot.domain;

/*
 * 
 * (Http请求返回的最外层对象)
 * @author name
 * 创建人: T
 * 时间: @date 2018/2/12
 * @version 1.0.0
 * @return 
 */
public class Result<T> {

    //  错误码
    private Integer code;

    //  提示信息
    private String msg;

    //  具体内容
    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
