package com.ThreadTest;

import java.util.HashMap;

/**
 * 静态代理
 * 1、代理对象和被代理对象都实现同一接口
 * 2、代理对象中有已接口为入参的构造方法
 * 3、创建代理对象调用方法
 *
 * Thread
 * 实现Runnable接口
 */
public class StaticProxy{
    public static void main(String[] args) {
        new Thread(()-> System.out.println("开启线程")).start();
        Wedding wedding = new Wedding(new you());
        wedding.happyMarry();
        HashMap<String,String> hashMap = new HashMap<>();
    }
}
interface Marry{
    void happyMarry();
}

class you implements Marry{

    @Override
    public void happyMarry() {
        System.out.println("自己结婚");
    }
}

class Wedding implements Marry{
    private Marry target;
    public Wedding(Marry target){
        this.target = target;
    }

    @Override
    public void happyMarry() {
        before();
        this.target.happyMarry();
        after();
    }
    void before(){
        System.out.println("婚礼之前");
    }
    void after(){
        System.out.println("婚礼之后");
    }
}