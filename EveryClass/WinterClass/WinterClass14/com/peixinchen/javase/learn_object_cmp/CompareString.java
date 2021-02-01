package com.peixinchen.javase.learn_object_cmp;

import java.util.Comparator;

class 用于比较String的秤 implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        // 做为秤，需要指定规则
        // 规定什么叫 大于、等于、小于
        // 这里用 String 的长度比较
        if (o1.length() < o2.length()) {
            // 认为 o1 小
            return -1;
        } else if (o1.length() == o2.length()) {
            return 0;
        } else {
            return 1;
        }
    }
}

public class CompareString {
    public static void main(String[] args) {
        String s = "hellos";
        String t = "world";

        用于比较String的秤 秤 = new 用于比较String的秤();
        int r = 秤.compare(s, t);
        if (r < 0) {
            System.out.println("s < t");
        } else if (r == 0) {
            System.out.println("s == t");
        } else {
            System.out.println("s > t");
        }
    }
}
