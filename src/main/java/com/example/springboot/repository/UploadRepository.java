package com.example.springboot.repository;


/*
 * 
 * (用一句话描述这个方法)
 * @author name
 * 创建人: T
 * 时间: @date 2018/2/13
 * @version 1.0.0
 * @return 
 */

import com.example.springboot.domain.Upload;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadRepository extends JpaRepository<Upload, Integer> {



}
