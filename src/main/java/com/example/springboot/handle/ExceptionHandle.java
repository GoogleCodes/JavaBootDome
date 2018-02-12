package com.example.springboot.handle;

import com.example.springboot.aspect.HttpAspect;
import com.example.springboot.domain.Result;
import com.example.springboot.exception.PersonException;
import com.example.springboot.tools.ResultTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 *
 * (处理异常捕获类)
 * @author name
 * 创建人: T
 * 时间: @date 2018/2/12
 * @version 1.0.0
 * @return
 */
@ControllerAdvice
public class ExceptionHandle {

    //  创建日志
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    /*
     *
     * (处理异常捕获方法)
     * @author name
     * 创建人: T
     * 时间: @date 2018/2/12
     * @version 1.0.0
     * @return com.example.springboot.domain.Result
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result ExceptionHandelGo(Exception e) {
        if (e instanceof PersonException) {
            PersonException personException = (PersonException) e;
            return ResultTools.error(personException.getCode(), personException.getMessage());
        } else {
            logger.error("系统异常 {}", e);
            return ResultTools.error(-1, "未知错误！");
        }
    }

}
