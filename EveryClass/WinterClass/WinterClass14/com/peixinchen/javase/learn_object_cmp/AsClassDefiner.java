package com.peixinchen.javase.learn_object_cmp;

import java.util.Objects;

class Teacher {
    public String name;
    public int age;
    public String course;

    public Teacher(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        // 如果引用指向的对象是同一个，则一定相等
        if (this == o) return true;

        // 如果 o 没有指向对象，则一定不相等
        // 如果 o 指向的对象和 this 指向的对象不是同一个类，则一定不相等
        if (o == null || this.getClass() != o.getClass()) return false;

        // 我认为三个属性都相等，才能说，两个 Teacher 对象相等
        // age 的类型是 int 类型，基本类型，所以可以直接用 “==” 比较
        // name/course 的类型是 String 类型，也是对象
        // 所以，这里我们做为 String 类的使用者，还得调用 equals 进行比较
        Teacher teacher = (Teacher) o;
        return age == teacher.age &&
                name.equals(teacher.name) &&
                course.equals(teacher.course);
    }
}

public class AsClassDefiner {
    public static void main(String[] args) {
        Teacher t1 = new Teacher("11", 11, "[11]");
        Teacher t2 = new Teacher("11", 11, "[11]");

        // 目前由于 三个属性 都相等，所以 t1 指向的对象 和 t2 指向的对象相等
        System.out.println(t1.equals(t2));
    }
}
