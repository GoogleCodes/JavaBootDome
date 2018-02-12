package com.example.springboot.web;

import com.example.springboot.domain.Person;
import com.example.springboot.enums.ResultEnums;
import com.example.springboot.exception.PersonException;
import com.example.springboot.repository.PersonRepository;
import com.example.springboot.tools.ResultTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * person 服务类
 * {@link Person}
 * {@link PersonRepository}
 * {@link Service}
 */
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    //  用户A
    Person personA = new Person();

    //  用户B
    Person personB = new Person();

    Person person = new Person();

    @Transactional
    public void insterTwo() {

        personA.setName("A");
        personRepository.save(personA);

        personB.setName("B");
        personRepository.save(personB);

    }

    public void getAge(Integer id) throws Exception {
        person = personRepository.findOne(id);
        Integer age = person.getAge();
        if (age < 10) {
            throw new PersonException(ResultEnums.PRIMARRY_SCHOOL);
        } else if (age > 10 && age < 16) {
            throw new PersonException(ResultEnums.MIDDLE_SCHOOL);
        }
    }

    /**
     * 通过Id查询一个女生的信息
     * @param id
     * @return
     */
    public Person findOne(Integer id) {
        return personRepository.findOne(id);
    }

}
