package learn_inner_class;

class OtherClass {
    public static void main(String[] args) {
        StaticClass.B b = new StaticClass.B();
    }
}

public class StaticClass {
    static class B {
    }

    public static void main(String[] args) {
        B b = new B();
    }
}
