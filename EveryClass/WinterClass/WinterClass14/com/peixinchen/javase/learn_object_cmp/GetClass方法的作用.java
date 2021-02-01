package com.peixinchen.javase.learn_object_cmp;

public class GetClass方法的作用 {
    public static void main(String[] args) {
        // getClass() 方法来自 Object 类
        // 所有的对象都有 getClass() 方法
        // 返回这个对象的类

        String s = "hello";
        Class aClass = s.getClass();
        System.out.println(aClass);

        GetClass方法的作用 t = new GetClass方法的作用();
        Class bClass = t.getClass();
        System.out.println(bClass);
    }
}
