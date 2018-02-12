package com.example.springboot.repository;


import org.springframework.stereotype.Repository;

import com.example.springboot.domain.*;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

import java.sql.*;

/*
 *
 * {@link User}
 * {@link Repository}
 * @author name
 * 创建人: T
 * 时间: @date 2018/2/12
 * @version 1.0.0
 */
@Repository
public class UserRepository {

    /*
     *
     * (采用内存型的存储方式  -> Map)
     * @author name
     * 创建人: T
     * 时间: @date 2018/2/12
     * @version 1.0.0
     */
    private final ConcurrentMap<Integer, User> repository = new ConcurrentHashMap<>();

    private final static AtomicInteger idGenerator = new AtomicInteger();


    /**
     *  保存用户对象
     * @param user
     * {@link User}
     * @return  如果保存成功，返回<code>true</code>, 否则，返回<code>false</code>
     */
    public boolean save(User user) {
        //  ID 自增
        Integer id = idGenerator.incrementAndGet();
        //  设置ID
        user.setId(id);
        return repository.put(id, user) == null;
    }

}
