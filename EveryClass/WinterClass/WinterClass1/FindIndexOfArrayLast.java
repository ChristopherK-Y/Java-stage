public class FindIndexOfArrayLast {
    public static int findIndexOfArray(long[] src, long target, int up, int down) {
        if (down > src.length || up < 0 || up > down) {
            throw new RuntimeException("输入的范围错误");
        }
        int index = -1;
        for (int i = down - 1; i >= up; i--) {
            if (target == src[i]) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        long[] array = new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(findIndexOfArray(array, 5, 1, 9));
    }

}
