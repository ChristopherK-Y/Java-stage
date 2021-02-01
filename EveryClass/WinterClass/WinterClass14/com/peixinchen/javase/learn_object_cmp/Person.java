package com.peixinchen.javase.learn_object_cmp;

public class Person implements Comparable<Person> {
    public String name;
    public int age;

//    @Override
//    public int compareTo(Person o) {
//        // this 和 o 指向的对象
//        // 我做为 Person 的定义者，按 age 进行比较
//        // 认为年龄小的对象，“比较小”
//
//        if (this.age < o.age) {
//            // 返回任意的负数
//            return -1;
//        } else if (this.age == o.age) {
//            return 0;
//        } else {
//            // 返回任意正数
//            return 1;
//        }
//    }

    @Override
    public int compareTo(Person o) {
        // this 和 o 指向的对象
        // 我做为 Person 的定义者，按 age 进行比较
        // 认为年龄大的对象，“比较小”

        if (this.age > o.age) {
            // 返回任意的负数
            return -1;
        } else if (this.age == o.age) {
            return 0;
        } else {
            // 返回任意正数
            return 1;
        }
    }
}
