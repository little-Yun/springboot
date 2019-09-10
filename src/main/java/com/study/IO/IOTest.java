package com.study.IO;

public class IOTest {

    public static void main(String[] args) {
        // 数组内容复制
        byte [] b = new byte[]{1,2,3,4,5,6,7,8,9,0};
        byte [] bytes1 = new byte[10];
        // 0-代表原数组起始位置  1-代表系新数组下标起始位置  6-代表长度
        System.arraycopy(b,0, bytes1, 1 , 6);

        StringBuffer sub = new StringBuffer();
        for (byte b1: bytes1) {
            sub.append(String.valueOf(b1));
        }
        System.out.println(sub.toString());
      //----------------------------------------------
        // 取两者中小的数
        int size = 5;
        int remaining = 12;
        int math = Math.min(size, remaining);
        System.out.println("====" + math);
    }
}
