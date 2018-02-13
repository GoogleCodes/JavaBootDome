package com.example.springboot.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Value("${dome}")
    private String dome;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say() {
        return dome;
    }

}
