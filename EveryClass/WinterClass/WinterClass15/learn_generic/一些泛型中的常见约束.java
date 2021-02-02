package learn_generic;

class Person<T> {
    // 可以利用 T 定义一个普通属性
    private T field;

    // 可以不能利用 T 定义一个静态属性
    // 时机问题
    // T 究竟是什么类型，是在用 Person 实例化对象的时候知道的
    // static 的东西和对象无关
    // 根本没法确定 T 的类型
    //private static T staticField;

    public T add() { return null; }
    //public static T sub() { return null; }


    public void someMethod() {
        T[] array = null;
        //T[] array2 = new T[10];
        T[] array3 = (T[])new Object[10];

        T t = null;
        //T t2 = new T();     // T 有没有无参构造方法？
    }
}

public class 一些泛型中的常见约束 {
    public static void main(String[] args) {
        Person<String> p = new Person<>();
        Person<Integer> q = new Person<>();
    }
}
