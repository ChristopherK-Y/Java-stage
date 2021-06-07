package demo10;

import java.util.concurrent.TimeUnit;

class MyThread extends Thread {
    MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        ThreadDemo.printThreadName();
    }
}

public class ThreadDemo {
    public static void printThreadName() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getId() + ":" + thread.getName());
    }

    public static void main(String[] args) {
        Thread.currentThread().setName("我是子线程");
        printThreadName();
        Thread t = new MyThread("我是子线程");
        t.start();
    }
}
