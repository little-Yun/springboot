package com.start.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @RequestMapping(value="/helloWorld")
    public String run() {
        return "helloWorld!";
    }
}
