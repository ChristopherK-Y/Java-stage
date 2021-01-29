package javase.learn_extends.e1;

public class Test {
    public static void main(String[] args) {
//        // 非常不推荐
//        DerivedClass.sMethod(); // <=> SuperClass.sMethod();
//        DerivedClass.sa = 10;   // <=> SuperClass.sa;
//
//        // 比较常用
//        DerivedClass o = new DerivedClass();
//        o.method();             // 执行子类的代码
//        SuperClass  o2 = new SuperClass();
//        o2.method();            // 执行父类的代码

        SuperClass o = new DerivedClass();
        // 不推荐写法1：通过引用调用静态方法
        // 静态方法不适用于：跟着对象判断规则
        // 使用引用调用静态方法时，会被替换成引用类型.方法()
        o.sMethod();    // SuperClass.sMethod();
    }
}
