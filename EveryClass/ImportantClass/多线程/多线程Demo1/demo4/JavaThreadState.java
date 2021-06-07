package demo4;

/*
enum 性别 {
    男, 女;
}

public class JavaThreadState {
    public static void main(String[] args) {
        性别[] values = 性别.values();
        for (性别 s : values) {
            System.out.println(s);
        }
    }
}
 */
public class JavaThreadState {
    public static void main(String[] args) {
        Thread.State[] values = Thread.State.values();
        for (Thread.State s : values) {
            System.out.println(s);
        }
    }
}
