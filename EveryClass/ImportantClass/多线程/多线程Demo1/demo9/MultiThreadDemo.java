package demo9;

class MyThread extends Thread {
    @Override
    public void run() {
        long r = 0;
        for (long j = 0; j < 1_0000_0000L; j++) {
            r += j;
        }
        System.out.println("计算结束");
    }
}

public class MultiThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        long b = System.currentTimeMillis();

        /*
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
         */
        Thread[] threads = new Thread[9];
        for (int i = 0; i < 9; i++) {
            threads[i] = new MyThread();
            threads[i].start();
        }
        /*
        t1.start();
        t2.start();
        t3.start();
        t4.start();
         */

        long r = 0;
        for (long j = 0; j < 1_0000_0000L; j++) {
            r += j;
        }
        System.out.println("计算结束");

        /*
        t1.join();
        t2.join();
        t3.join();
        t4.join();
         */
        for (int i = 0; i < 9; i++) {
            threads[i].join();
        }

        long e = System.currentTimeMillis();
        double t = (e - b) / 1000.0;
        System.out.printf("耗时: %.4f s", t);
    }
}
