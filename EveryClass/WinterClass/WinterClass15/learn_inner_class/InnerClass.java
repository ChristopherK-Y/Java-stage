package learn_inner_class;

class Other2Class {
    public static void main(String[] args) {
        InnerClass ic = new InnerClass();
        InnerClass.B b = ic.new B();
    }
}

public class InnerClass {
    class B {
    }

    public static void main(String[] args) {
        InnerClass ic = new InnerClass();
        B b = ic.new B();
    }
}
