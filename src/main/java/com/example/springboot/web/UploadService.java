package com.example.springboot.web;

import com.example.springboot.aspect.HttpAspect;
import com.example.springboot.repository.UploadRepository;
import com.example.springboot.tools.ResultTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.springboot.domain.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * (图片上传Servlet)
 * @author name
 * 创建人: T
 * 时间: @date 2018/2/13
 * @version 1.0.0
 * @return
 */
@Service
public class UploadService {

    //  创建日志
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Autowired
    private UploadRepository uploadRepository;

    //  实例化Upload
    Upload upload = new Upload();

    public Object FileUploadServlet(MultipartFile file) {
        //  判断文件是否不存在!
        if (file.isEmpty()) {
            return ResultTools.error(100, "文件不能为空!");
        }

        // 获取文件名
        String fileName = file.getOriginalFilename();
        logger.info("文件名称" + fileName);

        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);

        String newFileName = System.currentTimeMillis() + suffixName;
        logger.info("新名称"+ newFileName);

        //  创建路径
        String file_path = "E:/Workspaces/MyEclipse 2015/";

        //  创建文件
        File mkdirs = new File(file_path + newFileName);

        // 检测是否存在目录
        if (!mkdirs.getParentFile().exists()) {
            mkdirs.getParentFile().mkdirs();
        }
        try {
            //  保存文件
            file.transferTo(mkdirs);
            //  保存数据
            upload.setImage_name(newFileName);
            upload.setImage_path(file_path + newFileName);
            String create_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            upload.setCreate_time(create_time);
            return ResultTools.success(uploadRepository.save(upload));
        } catch(Exception e) {
            e.printStackTrace();
        }
        return ResultTools.error(100, "文件上传失败!");
    }


}
