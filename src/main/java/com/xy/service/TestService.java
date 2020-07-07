package com.xy.service;

import com.xy.bean.Student;

import java.util.List;

public interface TestService {

    void add(String name, int age);

    Student getStudentInfoByName(String name);

    List<Student> getAllStudents();
}
