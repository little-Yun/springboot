package com.xy.test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        Hashtable<String,Object> hashtable = new Hashtable<>();
        hashtable.put("name","zhangsan");

        System.out.println(hashtable.get("name"));



        Map<String,Object> hashMap = new HashMap<>();
        hashMap.put("123","123");
    }
}
