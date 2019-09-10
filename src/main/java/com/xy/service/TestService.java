package com.xy.service;

import com.xy.bean.Student;

public interface TestService {

    void add(String name, int age);

    Student getStudentInfoByName(String name);
}
