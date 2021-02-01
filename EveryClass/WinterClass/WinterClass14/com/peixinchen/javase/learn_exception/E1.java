package com.peixinchen.javase.learn_exception;

public class E1 {
    public static void main(String[] args) {
//        try {
//            int[] a = null;
//            a[0] = 18;  // <- 这句话会抛出 NPE
//            System.out.println("修改数组成功");
//        } catch (NullPointerException e) {
//            // e 指向的就是捕获到异常
//            // 异常对象的类型是 NPE 以及它子类
//            System.out.println("捕获到 NPE 异常了");
//            System.out.println(e.getClass());
//        }

//        try {
//            int[] a = null;
//            a[0] = 18;  // <- 这句话会抛出 NPE
//            System.out.println("修改数组成功");
//        } catch (Throwable e) {
//            // e 指向的就是捕获到异常
//            // 异常对象的类型是 NPE 以及它子类
//            System.out.println("捕获到 Throwable 异常了");
//            System.out.println(e.getClass());
//        }

        RuntimeException e1 = new NullPointerException();
        Exception e2 = new NullPointerException();
        Throwable e3 = new NullPointerException();
        // Error e4 = new NullPointerException();

        try {
            int[] a = null;
            a[0] = 18;  // <- 这句话会抛出 NPE
            System.out.println("修改数组成功");
        } catch (Error e) {
            // e 指向的就是捕获到异常
            // 异常对象的类型是 NPE 以及它子类
            System.out.println("捕获到 Error 异常了");
            System.out.println(e.getClass());
        }
    }
}
