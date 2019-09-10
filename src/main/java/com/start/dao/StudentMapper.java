package com.start.dao;

import com.start.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentMapper {

//    @Select("SELECT name,age FROM xy_data_student WHERE name = #{name}")
    Student getStudentInfoByName(@Param("name") String name);

//    @Insert("insert into xy_data_student(name,age) values(#{name} ,#{age})")
    public void saveStudentInfo(@Param("name") String name, @Param("age") int age);
}
