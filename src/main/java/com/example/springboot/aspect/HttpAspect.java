package com.example.springboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.*;

/*
 *
 * (AOP：面向切片)
 * @author name
 * 创建人: T
 * 时间: @date 2018/2/12
 * @version 1.0.0
 */
@Aspect
@Component
public class HttpAspect {

    //  创建日志
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    /**
     * 方法执行之前就已经执行
     * {@link Before}
     */
    @Pointcut("execution(public * com.example.springboot.controller.PersonController.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        //  创建ServletRequestAttributes
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        //  创建HttpServletRequest
        HttpServletRequest req = attributes.getRequest();

        //  URL
        logger.info("url={}", req.getRequestURI());

        //  method
        logger.info("method={}", req.getMethod());

        //  IP
        logger.info("ip={}", req.getRemoteAddr());

        //  类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringType() + "." + joinPoint.getSignature().getName());

        //  参数
        logger.info("args={}", joinPoint.getArgs());
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", JSON.toJSONString(object));
    }

}
