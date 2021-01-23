package 方法的使用_作业;
//2.求斐波那契数列的第n项。(迭代实现)
public class Fibonacci {
    // 1 2 3 4 5 6 7  8  9 10 11 12  13
    // 0 1 1 2 3 5 8 13 21 34 55 89 144
    public static long fibonacci(int n) {
        if (n == 1 || n == 2) {
            return n - 1;
        }
        long[] array = new long[]{0, 1};
        for (int i = 3; i < n; i++) {
            long temp = array[0] + array[1];
            array[0] = array[1];
            array[1] = temp;
        }
        return array[0]+array[1];
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(13));
    }
}
