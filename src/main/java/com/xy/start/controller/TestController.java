package com.xy.start.controller;

import com.alibaba.fastjson.JSONObject;
import com.xy.start.bean.Student;
import com.xy.start.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/xiaobai")
@ComponentScan("com.xy.start")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/add")
    @ResponseBody
    public String add(HttpServletRequest request){
        String name = request.getParameter("name");
        int age = Integer.valueOf(request.getParameter("age"));
        testService.add(name,age);

        JSONObject json = new JSONObject();
        this.getResult(json);
        return  json.toJSONString();
    }

    @RequestMapping(value = "/queryStudentInfo")
    @ResponseBody
    public String queryStudentInfo(HttpServletRequest request){
        String name = request.getParameter("name");
        Student student = testService.getStudentInfoByName(name);

        JSONObject json = (JSONObject) JSONObject.toJSON(student);
        // 结果处理
        this.getResult(json);
        return  json.toJSONString();
    }

    private void getResult(JSONObject json){
        json.put("resultCode","200");
        json.put("resuluMsg","调用成功");
    }
}
