package com.start.service;

import com.start.bean.Student;

public interface TestService {

    void add(String name,int age);

    Student getStudentInfoByName(String name);

}
