package com.example.springboot.domain;

/**
 * 用户模型
 * {time 2018/2/11}
 */
public class User {

    //  用户ID
    private Integer id;

    //  用户名称
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
