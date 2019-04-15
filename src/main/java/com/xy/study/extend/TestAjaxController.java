package com.xy.study.extend;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class TestAjaxController extends  BaseAjaxController {


    @RequestMapping("/test")
    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) {
        return "success!";
    }
}
