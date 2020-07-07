package com.xy.service.impl;

import com.xy.bean.Student;
import com.xy.dao.StudentMapper;
import com.xy.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService{

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student getStudentInfoByName(String name) {
       return studentMapper.getStudentInfoByName(name);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentMapper.getAllStudents();
    }

    @Override
    public void add(String name, int age) {
        studentMapper.saveStudentInfo(name,age);
    }
}
