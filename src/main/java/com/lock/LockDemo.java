package com.lock;

import org.openjdk.jol.info.ClassLayout;

class ObjectHeader{
    //64bit jvm中对象内存为8的倍数
    // 1、对象头 2、实例数据 3、填充数据（当对象内存不为8的倍数时，自动填充）
    boolean flag;
}
public class LockDemo {
    public static void main(String[] args) {
        System.out.println(ClassLayout.parseInstance(new ObjectHeader()).toPrintable());
    }
}
