package com.xy.study.asmDemo;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.IOException;

/**
 * AOP 的“无损注入
 */
public class SecureAccountGenerator {

    private static AccountGeneratorClassLoader classLoader = new AccountGeneratorClassLoader();

    private static Class secureAccountClass;

    public Account generateSecureAccount() throws ClassFormatError,
            InstantiationException, IllegalAccessException, IOException {
        if (null == secureAccountClass) {
            ClassReader cr = new ClassReader("com.xiaoyun.study.asm.asmDemo.Account");
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
            ClassAdapter classAdapter = new AddSecurityCheckClassAdapter(cw);
            cr.accept(classAdapter, ClassReader.SKIP_DEBUG);
            byte[] data = cw.toByteArray();
            secureAccountClass = classLoader.defineClassFromClassFile("Account$EnhancedByASM", data);
        }
        return (Account) secureAccountClass.newInstance();
    }


    private static class AccountGeneratorClassLoader extends ClassLoader {

        public Class defineClassFromClassFile(String className,
                                              byte[] classFile) throws ClassFormatError {
            return defineClass("Account$EnhancedByASM", classFile, 0, classFile.length);
        }
    }
}


