package com.example.springboot.exception;

import com.example.springboot.enums.ResultEnums;

/*
 *
 * (自定义异常捕获)
 * @author name
 * 创建人: T
 * 时间: @date 2018/2/12
 * @version 1.0.0
 * @return
 */
public class PersonException extends RuntimeException {
    //  异常代号
    private Integer code;

    //  异常信息
    public String message;

    public PersonException(ResultEnums resultEnums) {
        super(resultEnums.getMessage());
        this.code = resultEnums.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
