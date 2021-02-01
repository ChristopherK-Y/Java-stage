package com.peixinchen.javase.learn_exception;

public class E2 {
    public static void main(String[] args) {
//        try {
//            int[] a = null;
//            //a[0] = 18;
//            System.out.println("正常结束");
//        } catch (NullPointerException e) {
//            System.out.println("捕获到异常");
//        } finally {
//            System.out.println("最后都要走这里");
//        }

        try {
            int[] a = null;
            a[0] = 18;
            System.err.println("正常结束");
        } finally {
            // 异常打印默认就在 err 上
            // 只要两个都打在 err 上，顺序才能保证
            System.err.println("没有捕获，但也要执行这里");
        }
    }
}
