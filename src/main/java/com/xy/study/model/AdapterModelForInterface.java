package com.xy.study.model;

public class AdapterModelForInterface {

    public static void main(String[] args) {
        PSP psp = new AdapterUser();
        psp.a();
        psp.b();
    }
}


interface PSP{

    void a();

    void b();

    void c();
}

abstract class PSPuser implements  PSP{
    @Override
    public void a() {

    }

    @Override
    public void b() {

    }

    @Override
    public void c() {

    }
}


class AdapterUser extends PSPuser{

    public void a() {
        System.out.println("this is a adapterModel for interface method a!");
    }


    public void b() {
        System.out.println("this is a adapterModel for interface method b!");
    }
}