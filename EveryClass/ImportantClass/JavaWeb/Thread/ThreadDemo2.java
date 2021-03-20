package java_web.thread;

//200亿次加操作，串行和并发的时间差
public class ThreadDemo2 {

    public static void main(String[] args) {
        serial();//串行
        concurrency();//并发
    }


    private static void serial() {
        long beginTime = System.currentTimeMillis();
        final long times = 100_0000_0000L;
        long a = 0;
        for (long i = 0; i < times; i++) {
            a++;
        }
        long b = 0;
        for (long i = 0; i < times; i++) {
            b++;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Serial: time costs " + (endTime - beginTime) + " ms");
    }

    private static void concurrency() {
        long beginTime = System.currentTimeMillis();
        final long times = 100_0000_0000L;
        Thread t1 = new Thread(() -> {
            long a = 0;
            for (long i = 0; i < times; i++) {
                a++;
            }
        });
        Thread t2 = new Thread(() -> {
            long b = 0;
            for (long i = 0; i < times; i++) {
                b++;
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();//等待t1、t2进程的结束，以获取正确的时间
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Concurrency: time costs " + (endTime - beginTime) + " ms");
    }
}
