package com.xy.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xy.aop.LogAspect;
import com.xy.service.TestService;
import com.xy.bean.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/add")
    @ResponseBody
    public String add(@RequestBody Student student) {
        String name = student.getName();
        int age = student.getAge();
        testService.add(name, age);

        JSONObject json = this.getResult(null);
        return json.toJSONString();
    }

    @RequestMapping(value = "/queryStudentInfo")
    @ResponseBody
    @LogAspect
    public String queryStudentInfo(Student stu) {
        String name = stu.getName();
        Student student = testService.getStudentInfoByName(name);
        JSONObject json = this.getResult(student);
        return json.toJSONString();
    }

    @RequestMapping("/getAllStudents")
    @ResponseBody
    public List<Student> getAllStudents() {
        List<Student> resultList = testService.getAllStudents();
        return resultList;
    }

    private JSONObject getResult(Student student) {
        JSONObject json = null;
        if (null == student) {
            json = new JSONObject();
        } else {
            json = (JSONObject) JSONObject.toJSON(student);
        }
        json.put("resultCode", "200");
        json.put("resuluMsg", "调用成功");

        return json;
    }
}
