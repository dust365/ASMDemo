package com.geektime.asm;

import com.geektime.asm.adapter.AdviceMMAdapter;
import com.geektime.asm.adapter.TraceMethodAdapter;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

public  class TraceClassAdapter extends ClassVisitor {


    private String className;

    TraceClassAdapter(int i, ClassVisitor classVisitor) {
        super(i, classVisitor);
    }


    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);
        this.className = name;
        if (className.contains("MainActivity")){
            Log.d("ASM11", "visit: className="+className);
        }

    }

    @Override
    public void visitInnerClass(final String s, final String s1, final String s2, final int i) {
        super.visitInnerClass(s, s1, s2, i);
    }


    @Override
    public MethodVisitor visitMethod(int access, String name, String desc,
                                     String signature, String[] exceptions) {
//       Log.e("ASM11","visitMethod");
        MethodVisitor methodVisitor = cv.visitMethod(access, name, desc, signature, exceptions);
//        if (className.equals("MainActivity")&&name.equals("MM")){
//            Log.e("ASM11","--------Find  MainActivity ------------methodName"+name+" desc="+desc+" signature="+signature);
            return new AdviceMMAdapter(api, methodVisitor, access, name, desc, className);

//        }
//        else {
//          return new TraceMethodAdapter(api, methodVisitor, access, name, desc, this.className);
//          return   null;
//        }
    }


    @Override
    public void visitEnd() {
        super.visitEnd();
    }
}
