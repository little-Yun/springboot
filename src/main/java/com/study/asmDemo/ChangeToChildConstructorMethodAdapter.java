package com.study.asmDemo;

import org.objectweb.asm.MethodAdapter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class ChangeToChildConstructorMethodAdapter extends MethodAdapter {

    private String superClassName;

    public ChangeToChildConstructorMethodAdapter(MethodVisitor methodVisitor,String superClassName) {
        super(methodVisitor);
        this.superClassName = superClassName;
    }

    public void visitMethodInsn(int opcode, String owner, String name, String desc) {
        // 调用父类的构造函数时
        if (opcode == Opcodes.INVOKESPECIAL && name.equals("<init>")) {
            owner = superClassName;
        }
        super.visitMethodInsn(opcode, owner, name, desc);// 改写父类为 superClassName
    }

}
