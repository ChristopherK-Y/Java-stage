import java.util.Arrays;

public class Demo1 {
    public static void main(String[] args) {
//        long[][] example = new long[5][];
//        long[] x = example[0];
//        System.out.println(x);
//        System.out.println(x[0]);
        long[][] example = new long[][]{{1, 2}, {3, 4}, {5, 5, 6, 7, 8, 98, 3242}};
        printTwoDimensionalArray(example);

    }

    public static void printTwoDimensionalArray(long[][] x) {
        for (long[] longs : x) {
            System.out.println(Arrays.toString(longs));
        }
    }
}
