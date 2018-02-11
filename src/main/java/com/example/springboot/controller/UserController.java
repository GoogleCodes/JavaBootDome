package com.example.springboot.controller;


import com.example.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.domain.User;

/**
 * 用戶控制器
 * {time 2018/2/11}
 */

@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/person/save")
    public User user(@RequestParam String name) {
        User user = new User();
        user.setName(name);
        if(userRepository.save(user)) {
            System.out.println("user..." + user);
        }
        return user;
    }

}
