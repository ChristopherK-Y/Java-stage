package e1;

public class DerivedClass extends SuperClass {
    // 想要重写方法，只能重写普通方法
    @Override
    public void method() {
        super.method();
    }

    public static void sMethod() {
        System.out.println("我是子类中的静态方法");
    }
}
