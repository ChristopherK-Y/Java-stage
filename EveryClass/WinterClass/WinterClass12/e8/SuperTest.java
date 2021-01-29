package javase.learn_extends.e8;

import java.util.Date;

public class SuperTest extends Date {
    private void test() {
        System.out.println(super.getClass().getName());
    }

    public static void main(String[] args) {
        SuperTest o = new SuperTest();

        // 打印 o 这个引用指向的对象的类型的名字
        //System.out.println(o.getClass().getName());

        o.test();
    }
}
