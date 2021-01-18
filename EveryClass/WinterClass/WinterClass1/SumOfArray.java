public class SumOfArray {
    public static long sumOfArray(long[] src, int up, int down) {
        if (down > src.length || up < 0) {
            throw new RuntimeException("输入的范围错误");
        }
        int sum = 0;
        for (int i = up; i < down; i++) {
            sum += src[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        long[] array = new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(sumOfArray(array, 0, 7));
    }
}
