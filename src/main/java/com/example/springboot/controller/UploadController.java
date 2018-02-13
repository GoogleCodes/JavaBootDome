package com.example.springboot.controller;

import com.example.springboot.aspect.HttpAspect;
import com.example.springboot.tools.ResultTools;
import com.example.springboot.web.UploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 *
 * (图片上传控制器)
 * @author name
 * 创建人: T
 * 时间: @date 2018/2/13
 * @version 1.0.0
 * @return
 */
@RestController
public class UploadController {

    //  创建日志
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    //  实例化UploadServce
    @Autowired
    private UploadService uploadService;

    /**
     * 文件上传控制类
     * @param file
     * @return
     */
    @RequestMapping(value = "/upload/img", produces = "application/json; charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public Object UploadGetImages(@RequestParam(value = "file") MultipartFile file) {
        return uploadService.FileUploadServlet(file);
    }



}
