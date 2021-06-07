package demo6;

import java.util.Scanner;

public class OneThreadDemo {
    public static long fib(int n) {
        if (n < 2) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.print("请输入要计算的数字: ");
            int n = s.nextInt();
            long r = fib(n);
            System.out.printf("fib(%d) = %d\n", n, r);
        }
    }
}
