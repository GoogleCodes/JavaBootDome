package com.example.springboot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.*;

/*
 *
 * (上传图片类)
 * @author name
 * 创建人: T
 * 时间: @date 2018/2/13
 * @version 1.0.0
 * @return
 */
@Entity
public class Upload {

    //  ID
    @Id
    @GeneratedValue
    private Integer id;

    //  上传路径
    private String image_path;

    //  上传名称
    private String image_name;

    //  创建时间
    private String create_time;

    //	更新时间
    private Date update_time;

    //	删除时间
    private Date delete_time;

    //	用户ID
    private String user_id;

    //  图片标题
    private String image_title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Date getDelete_time() {
        return delete_time;
    }

    public void setDelete_time(Date delete_time) {
        this.delete_time = delete_time;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getImage_title() {
        return image_title;
    }

    public void setImage_title(String image_title) {
        this.image_title = image_title;
    }

    @Override
    public String toString() {
        return "Upload{" +
                "id=" + id +
                ", image_path='" + image_path + '\'' +
                ", image_name='" + image_name + '\'' +
                ", create_time='" + create_time + '\'' +
                ", update_time=" + update_time +
                ", delete_time=" + delete_time +
                ", user_id='" + user_id + '\'' +
                ", image_title='" + image_title + '\'' +
                '}';
    }
}
