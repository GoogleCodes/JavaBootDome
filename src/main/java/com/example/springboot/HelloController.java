package com.example.springboot;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say() {

        return "Hello, World!";
    }

}
