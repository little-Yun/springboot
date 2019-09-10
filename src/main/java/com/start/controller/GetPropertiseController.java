package com.start.controller;

import com.start.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 获取spring boot配置几种方式
 */
@RestController
public class GetPropertiseController {

    // 配置改造
    @Autowired
    private User user;

    //通过注入环境变量来获取配置信息
    @Autowired
    private Environment env;

    //通过注解获取配置文件信息
    @Value("${com.xy.title}")
    private String title;

    @Value("${com.test}")
    private String test;

    @RequestMapping(value = "/getType")
    // 读取springboot启动加载的环境配置文件
    public String getType(){
        return "get getType:" + env.getProperty("com.xy.type");
    }

    @RequestMapping("getType1")
    // 配置读取
    public String getType1(){
        return "get getType1:" + user.getType();
    }

    @RequestMapping("/getTetile")
    public String getTitle1(){
        System.out.println("get test:" + test);
        System.out.println("get title:"+ title);
        return "get titile:" + title;
    }
}
