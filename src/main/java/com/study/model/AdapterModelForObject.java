package com.study.model;

/**
 * 对象适配器模式
 */
public class AdapterModelForObject {

    public static void main(String[] args) {
        PS2 ps = new AdapterForObject(new Usber());

        ps.isPS2();
    }
}


class AdapterForObject implements PS2{
    private USB usb;

    public AdapterForObject(USB usb) {
        this.usb = usb;
    }

    @Override
    public void isPS2() {
        usb.isUsb();
    }
}



