package demo6;

import java.util.Scanner;

class MyThread extends Thread {
    int n;

    @Override
    public void run() {
        long r = fib(this.n);
        System.out.printf("fib(%d) = %d\n", this.n, r);
    }

    public static long fib(int n) {
        if (n < 2) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }
}

public class MultiThreadDemo {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.print("请输入要计算的数字: ");
            int n = s.nextInt();

            MyThread t = new MyThread();
            t.n = n;
            t.start();
        }
    }
}
