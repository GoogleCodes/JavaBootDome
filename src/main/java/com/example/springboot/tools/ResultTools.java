package com.example.springboot.tools;

import com.example.springboot.domain.*;

/*
 *
 * (封装工具类)
 * @author name
 * 创建人: T
 * 时间: @date 2018/2/12
 * @version 1.0.0
 * @return
 */
public class ResultTools {

    /*
     *
     * (实例化Result类)
     * @author name
     * 创建人: T
     * 时间: @date 2018/2/12
     * @version 1.0.0
     * @return
     */
    private static Result result = new Result();

    /*
     *
     * (请求成功回调方法)
     * @author name
     * 创建人: T
     * 时间: @date 2018/2/12
     * @version 1.0.0
     * @return com.example.springboot.domain.Result
     */
    public static Result success(Object object) {
        result.setCode(0);
        result.setMsg("ok!");
        result.setData(object);
        return result;
    }

    /**
     *
     * (请求成功返回null)
     * @author name
     * 创建人: T
     * 时间: @date 2018/2/12
     * @version 1.0.0
     * @return com.example.springboot.domain.Result
     */
    public static Result success() {
        return success(null);
    }

    /*
     *
     * (请求错误返回)
     * @author name
     * 创建人: T
     * 时间: @date 2018/2/12
     * @version 1.0.0
     * @return com.example.springboot.domain.Result
     */
    public static Result error(Integer code, String message) {
        result.setCode(code);
        result.setMsg(message);
        return result;
    }

}
