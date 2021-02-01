package com.peixinchen.javase.learn_object_cmp;

import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class AsClassUser {
    // 做为类的使用者，老老实实地调用 equals 进行对象的比较即可
    // 进行对象比较时，除非你就是要比较引用是否指向同一个对象
    // 否则，就很少用到 "==" 和 "!="
    public static void main(String[] args) {
        {
            Random r1 = new Random();
            Random r2 = new Random();
            System.out.println(r1.equals(r2));
            /*
            Random 类的定义者，不认为两个
            Random 对象有进行 相等比较 的意义
            所以没有重写 equals 方法
             */
        }

        {
            String s1 = "hello";
            String s2 = "hello";

            System.out.println(s1.equals(s2));
            /*
            String 类重写了 equals 方法
             */
        }

        {
            Scanner s1 = new Scanner(System.in);
            Scanner s2 = new Scanner(System.in);

            System.out.println(s1.equals(s2));
            /*
            Scanner 类的定义者，不认为两个
            Scanner 对象有进行 相等比较 的意义
            所以没有重写 equals 方法
             */
        }
    }
}
