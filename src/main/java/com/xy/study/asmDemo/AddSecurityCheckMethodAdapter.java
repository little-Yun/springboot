package com.xy.study.asmDemo;

import org.objectweb.asm.MethodAdapter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class AddSecurityCheckMethodAdapter extends MethodAdapter implements MethodVisitor{

    public AddSecurityCheckMethodAdapter(MethodVisitor cv) {
        super(cv);
    }

    public void visitCode() {
        visitMethodInsn(Opcodes.INVOKESTATIC, "com/xy/study/asmDemo/SecurityChecker", "checkSecurity", "()V");
    }

}
