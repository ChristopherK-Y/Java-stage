import java.util.Arrays;

public class SearchTest {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] b = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
//        System.out.println(Arrays.binarySearch(a, 5));
//        System.out.println(Arrays.binarySearch(a, 11));
        System.out.println(Arrays.equals(a, b));
        int[] x = Arrays.copyOf(a, 4);
        System.out.println(Arrays.toString(x));
    }
}
