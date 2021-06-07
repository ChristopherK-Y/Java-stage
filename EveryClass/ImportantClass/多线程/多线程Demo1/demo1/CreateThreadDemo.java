package demo1;

import java.util.concurrent.TimeUnit;

// MyThread 对象代表一个线程
class MyThread extends Thread {
    //boolean condition = true;

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                System.out.println("我是子线程");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException exc) {
                exc.printStackTrace();
                break;
            }
        }
    }
}

public class CreateThreadDemo {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        //Thread t = new MyThread();

        thread.start();     // 就绪状态

        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("我是主/父线程");
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException exc) {
                exc.printStackTrace();
            }
        }

        // condition = false
        //thread.condition = false;
        thread.interrupt();
    }
}
