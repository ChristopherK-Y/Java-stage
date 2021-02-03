import java.util.Arrays;

public class 不用静态导入 {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3 };

        System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        Arrays.fill(a, 10);
    }
}
