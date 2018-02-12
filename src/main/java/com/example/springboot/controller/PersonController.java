package com.example.springboot.controller;

import com.example.springboot.domain.Person;
import com.example.springboot.domain.Result;
import com.example.springboot.repository.PersonRepository;
import com.example.springboot.tools.ResultTools;
import com.example.springboot.web.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.BindException;
import java.util.*;

/*
 *
 * (Person 控制层)
 * @author name
 * 创建人: T
 * 时间: @date 2018/2/12
 * @version 1.0.0
 */
@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    //  实例化service
    @Autowired
    private PersonService personService;

    //  实例化Person类
    Person person = new Person();

    //  实例化Result类
    Result result = new Result();

    /**
     * 获取所有信息
     * @return
     */
    @GetMapping(value = "/persons/info")
    public Object personList() {
        return ResultTools.success(personRepository.findAll());
    }

    /**
     * 增加信息
     * @param name
     * @return
     */
    @PostMapping(value = "/persons/add")
    public Person personAdd(@RequestParam("name") String name) {
        person.setName(name);
        return personRepository.save(person);
    }

    /*
     *
     * (增加信息)
     * @author name
     * 创建人: T
     * 时间: @date 2018/2/12
     * @version 1.0.0
     * @return java.lang.Object
     */
    @PostMapping(value = "/person/addDate")
    public Object personAddDate(@Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultTools.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        person.setName(person.getName());
        person.setAge(person.getAge());
        ResultTools.success(personRepository.save(person));
        return ResultTools.success(personRepository.save(person));
    }

    /*
     * 
     * (用一句话描述这个方法)
     * @author name
     * 创建人: T
     * 时间: @date 2018/2/12
     * @version 1.0.0
     * @return com.example.springboot.domain.Person
     */
    @PostMapping(value = "/persons/search")
    public Person personFindOne(@RequestParam("id") Integer id) {
        return personRepository.findOne(id);
    }

    /**
     * 查询名称
     * @param name
     * @return
     */
    @PostMapping(value = "/persons/searchName")
    public List<Person> personFindByName(@RequestParam("name") String name) {
        return personRepository.findByName(name);
    }

    /**
     * 更新数据
     * @param id
     * @param name
     * @return
     */
    @PostMapping(value = "/person/update")
    public Person personUpdate(@PathVariable("id") Integer id, @RequestParam("name") String name) {
        person.setId(id);
        person.setName(name);
        return personRepository.save(person);
    }

    /**
     * 删除数据
     * @param id
     */
    @PostMapping(value = "/persons/delete")
    public void personDelete(@RequestParam("id") Integer id) {
        personRepository.delete(id);
    }

    @PostMapping(value = "/person/twins")
    public void personTwins() {
        personService.insterTwo();
    }


    @GetMapping(value = "/person/getAge/{id}")
    public void personGetAge(@PathVariable("id") Integer id) throws Exception {
        personService.getAge(id);
    }

}