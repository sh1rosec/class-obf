package me.n1ar4.clazz.obfuscator.asm;

import me.n1ar4.clazz.obfuscator.Const;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;


public class CompileInfoChanger extends ClassVisitor {
    public CompileInfoChanger(ClassVisitor classVisitor) {
        super(Const.ASMVersion, classVisitor);
    }

    @Override
    public void visitSource(String source, String debug) {
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
        return new CompileInfoChangerMethodAdapter(mv);
    }

    static class CompileInfoChangerMethodAdapter extends MethodVisitor {
        CompileInfoChangerMethodAdapter(MethodVisitor mv) {
            super(Const.ASMVersion, mv);
        }

        @Override
        public void visitLineNumber(int line, Label start) {
        }
    }
}