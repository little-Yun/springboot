package com.xy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 获取spring boot配置几种方式
 */
@Slf4j
@RestController
public class GetPropertiseController {

    //通过注解获取配置文件信息
    @Value("${com.xy.title}")
    private String title;

    @Value("${com.xy.test}")
    private String test;

    @RequestMapping("/getTetile")
    public String getTitle1() {
        log.info("get test:{}", test);
        log.info("get user title:{}", title);
        return "get titile:" + title;
    }
}
