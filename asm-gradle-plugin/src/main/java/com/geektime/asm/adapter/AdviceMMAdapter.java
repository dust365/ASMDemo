package com.geektime.asm.adapter;

import com.geektime.asm.Log;

import org.jetbrains.org.objectweb.asm.util.Printer;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.AdviceAdapter;

public class AdviceMMAdapter extends AdviceAdapter {

    private static String TAG = "ASM11";
    private final String className;
    private final String methodName;

    boolean find = true;


    public AdviceMMAdapter(int api, MethodVisitor mv, int access, String name, String desc, String className) {
        super(api, mv, access, name, desc);
        this.className = className;
        this.methodName = name;
    }

    @Override
    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
        if (owner.equals("com/sample/asm/MainActivity") && name.equals("MM")) {
            Log.e(TAG, "visitMethod Insn: className=" + owner + " mName=" + name + " desc=" + desc);
            find = true;
        }
        super.visitMethodInsn(opcode, owner, name, desc, itf);
    }

    @Override
    protected void onMethodEnter() {
        if (className.equals("com/sample/asm/MainActivity") && methodName.equals("MM") && find) {
            Log.e(TAG, "onMethodEnter: ");
            visitLdcInsn("AAA");
            visitLdcInsn("111111111");
            visitMethodInsn(INVOKESTATIC, "android/util/Log", "d", "(Ljava/lang/String;Ljava/lang/String;)I", false);
            visitInsn(POP);


            Label label0 = new Label();
            Label label1 = new Label();
            Label label2 = new Label();
            visitTryCatchBlock(label0, label1, label2, "java/lang/Exception");
            visitLabel(label0);
            visitLdcInsn("123");
            visitVarInsn(ASTORE, 1);
            visitLabel(label1);
            Label label3 = new Label();
            visitJumpInsn(GOTO, label3);
            visitLabel(label2);
            visitVarInsn(ASTORE, 1);
            visitVarInsn(ALOAD, 1);
            visitMethodInsn(INVOKEVIRTUAL, "java/lang/Exception", "printStackTrace", "()V", false);
            visitLabel(label3);
            visitInsn(RETURN);
            visitMaxs(1, 2);
            visitInsn(POP);
        }
    }

    @Override
    protected void onMethodExit(int opcode) {
        if (className.equals("com/sample/asm/MainActivity") && methodName.equals("MM") && find) {
            Log.e(TAG, "onMethodExit: ");
            visitLdcInsn("BBB");
            visitLdcInsn("2222222");
            visitMethodInsn(INVOKESTATIC, "android/util/Log", "d", "(Ljava/lang/String;Ljava/lang/String;)I", false);
            visitInsn(POP);
        }
    }
}
