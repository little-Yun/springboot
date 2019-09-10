package com.study.reflect;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflect {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class clazz = Class.forName("com.study.reflect.Student");
        //获取所有构造方法
        Constructor[] conArray = clazz.getDeclaredConstructors();
        for (Constructor con : conArray) {
            System.out.println("constract con:" + con);
        }


        Student stu = (Student) clazz.getConstructor().newInstance();

        //只能获取到公有字段
        Field field = clazz.getField("name");
        field.set(stu, "zhangsan");

        System.out.println("Reflect.main first stu:" + stu);

        //获取全部字段包括【公私有字段】
        field = clazz.getDeclaredField("age");
        //暴力解除私有限制
        field.setAccessible(true);
        field.set(stu, 18);

        System.out.println("Reflect.main seconds stu:" + stu);

        //获取方法 【公私有】
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            System.out.println("student method name:" + m);
        }

        //公有方法
        Method m = clazz.getMethod("show", String.class);
        m.invoke(stu, "public");

        //私有方法
        m = clazz.getDeclaredMethod("run", String.class);
        m.setAccessible(true);
        m.invoke(stu,"private");
    }
}

class Student {

    public String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //-----------------方法测试-----------------------
    public void show(String name) {
        System.out.println("public method :" + name);
    }

    private void run(String name){
        System.out.println("private method :" + name);
    }
    //---------------构造方法-------------------
    //（默认的构造方法）
    public Student(String str) {
        System.out.println("(默认)的构造方法 s = " + str);
    }

    //无参构造方法
    public Student() {
        System.out.println("调用了公有、无参构造方法执行了。。。");
    }

    //有一个参数的构造方法
    public Student(char name) {
        System.out.println("姓名：" + name);
    }

    //有多个参数的构造方法
    public Student(String name, int age) {
        System.out.println("姓名：" + name + "年龄：" + age);//这的执行效率有问题，以后解决。
    }

    //受保护的构造方法
    protected Student(boolean n) {
        System.out.println("受保护的构造方法 n = " + n);
    }

    //私有构造方法
    private Student(int age) {
        System.out.println("私有的构造方法   年龄：" + age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}