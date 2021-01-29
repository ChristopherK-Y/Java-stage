package javase.learn_extends.e7;

class Sub extends Base {
    private String baseName = "sub";

    public void callName() {
        System.out.println(baseName);
    }
}

public class Base {
    private String baseName = "base";

    public Base() {
        callName();
    }

    public void callName() {
        System.out.println(baseName);
    }

    public static void main(String[] args) {
        new Sub();
    }
}
