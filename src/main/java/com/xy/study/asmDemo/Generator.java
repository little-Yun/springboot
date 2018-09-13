package com.xy.study.asmDemo;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;

/**
 *  通过ASM框架直接操纵类方法
 */
public class Generator{
    public static void main(String [] args) throws Exception {
        ClassReader cr = new ClassReader("com.xiaoyun.study.asm.asmDemo.Account");
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        ClassAdapter classAdapter = new AddSecurityCheckClassAdapter(cw);
        cr.accept(classAdapter, ClassReader.SKIP_DEBUG);
        byte[] data = cw.toByteArray();

        File file = new File("/Users//apple//Documents//workspace//springboot//target//classes//com//xiaoyun//study//asm//asmDemo//Account.class");
        FileOutputStream fout = new FileOutputStream(file);
        fout.write(data);
        fout.close();
    }
}