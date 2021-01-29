package javase.learn_extends.e1;

public class SuperClass {
    // 普通属性和方法，适用于继承规则
    public int a;

    public void method() {}

    // 静态属性和方法，不适用于继承规则
    public static int sa;

    public static void sMethod() {
        System.out.println("我是父类中的静态方法");
    }
}
