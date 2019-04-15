package com.xy.test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList  = new LinkedList<Integer>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
        }

        linkedList.forEach(e -> System.out.println(e));


        // HASHMap
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("1",2);
    }

}
