import java.util.Arrays;

public class FindMaxOfArray {
    public static long findMax(long[] a, int up, int down) {
        if (down > a.length || up < 0) {
            throw new RuntimeException("输入的范围错误");
        }
        long max = a[up];
        for (int i = up; i < down; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        long[] array = new long[]{213213, 123213, 123, 4123, 41231};
        System.out.println(findMax(array, 2, 4));
    }
}
