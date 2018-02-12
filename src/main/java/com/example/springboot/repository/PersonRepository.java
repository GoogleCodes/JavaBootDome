package com.example.springboot.repository;

import com.example.springboot.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

/**
 *  应用层
 *  {@link Person}
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {

    /**
     * 通过查询来获取名称
     * @param name
     * @return
     */
    public List<Person> findByName(String name);

}
