package com.xy.dao;

import com.xy.bean.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    List<Student> getAllStudents();

    Student getStudentInfoByName(String name);

    void saveStudentInfo(@Param("name") String name, @Param("age") int age);

}
