package com.start.service.impl;

import com.start.bean.Student;
import com.start.dao.StudentMapper;
import com.start.service.TestService;
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
