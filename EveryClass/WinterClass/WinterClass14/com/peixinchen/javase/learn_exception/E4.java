package com.peixinchen.javase.learn_exception;

public class E4 {
    private static int method() {
        try {
            int[] a = null;
            a[0] = 100;
            return 10;
        } catch (RuntimeException e) {
            return 20;
        } finally {
            // 建议大家不要在 finally 中返回
            // 但遇到笔试题要知道
            return 30;
        }
    }

    public static void main(String[] args) {
        int r = method();
        System.out.println(r);
    }
}
