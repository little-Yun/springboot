package com.xy.start.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xy.start.dao")
public class springBootMain {

    public static void main(String[] args) {
        SpringApplication.run(springBootMain.class, args);
    }
}
