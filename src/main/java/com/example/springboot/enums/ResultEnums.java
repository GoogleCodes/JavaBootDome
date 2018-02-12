package com.example.springboot.enums;

/*
 * 
 * (枚举 => 举例一些常用的变量)
 * @author name
 * 创建人: T
 * 时间: @date 2018/2/12
 * @version 1.0.0
 * @return 
 */
public enum ResultEnums {
    UNKONW_ERRPR(-1, "未知错误"),

    SUCCESS(0, "请求成功"),

    PRIMARRY_SCHOOL(100, "您可能在上小学"),

    MIDDLE_SCHOOL(101, "您可能在上初中")

    ;

    //  异常编号
    private Integer code;

    //  异常信息
    private String message;

    ResultEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
