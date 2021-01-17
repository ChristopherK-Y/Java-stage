public class FindMinOfArray {
    public static long findMin(long[] a, int up, int down) {
        if (down > a.length || up < 0) {
            throw new RuntimeException("输入的范围错误");
        }
        long min = a[up];
        for (int i = up; i < down; i++) {
            if (a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        long[] array = new long[]{213213, 123213, 123, 4123, 41231};
        System.out.println(findMin(array, 2, 4));
    }

}
