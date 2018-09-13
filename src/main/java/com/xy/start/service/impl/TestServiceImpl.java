package com.xy.start.service.impl;

import com.xy.start.bean.Student;
import com.xy.start.dao.StudentMapper;
import com.xy.start.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student getStudentInfoByName(String name) {
       return studentMapper.getStudentInfoByName(name);
    }

    @Override
    public void add(String name, int age) {
        studentMapper.saveStudentInfo(name,age);
    }
}
