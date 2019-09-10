package com.xy.study.model;

/**
 * 类适配器模式
 */
public class AdapterModelForClass {

    public static void main(String[] args) {

        PS2 ps = new AdapterForClass();
        ps.isPS2();
    }
}



interface  PS2{
   void isPS2();
}



interface USB{

   void isUsb();
}


class Usber implements USB{

    @Override
    public void isUsb() {

        System.out.println("this is a usb for!");
    }
}


class AdapterForClass extends Usber implements PS2{

    @Override
    public void isPS2() {
        isUsb();
    }
}