import java.util.Arrays;

public class FullArray {
    public static void fullArray(long[] src, long target, int up, int down) {
        if (down > src.length || up < 0 || up > down) {
            throw new RuntimeException("输入范围错误");
        }
        for (int i = up; i < down; i++) {
            src[i] = target;
        }
    }

    public static void main(String[] args) {
        long[] array = new long[10];
        fullArray(array, 123, 0, 6);
        System.out.println(Arrays.toString(array));
    }
}
