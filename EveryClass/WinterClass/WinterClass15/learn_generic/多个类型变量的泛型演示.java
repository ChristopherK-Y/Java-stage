package learn_generic;

class Something<A, B, C> {
    private A a;
    private B b;
    private C c;

    public Something(A a, B b, C c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

public class 多个类型变量的泛型演示 {
    public static <A, B, C> A method(B b, C c) {
        return null;
    }

    public static void main(String[] args) {
        Integer r = 多个类型变量的泛型演示.<Integer, String, String>method("hello", "world");

        Something<Boolean, Integer, Boolean> st = new Something<>(false, 13, true);
    }
}
