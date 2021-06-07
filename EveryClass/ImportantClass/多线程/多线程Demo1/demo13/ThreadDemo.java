package demo13;

import java.util.concurrent.TimeUnit;

class MyThread extends Thread {
    @Override
    public void run() {
        while (!ThreadDemo.quit) {}
    }
}

public class ThreadDemo {
    volatile static boolean quit = false;

    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        quit = true;
    }
}
