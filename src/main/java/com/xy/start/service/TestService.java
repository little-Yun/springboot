package com.xy.start.service;

import com.xy.start.bean.Student;

public interface TestService {

    void add(String name,int age);

    Student getStudentInfoByName(String name);

}
