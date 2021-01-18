import java.util.Arrays;

public class ForTest {
//    public static void main(String[] args) {
//        long[] array = new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        System.out.println(MyArrays.toString(array));
//        long[] array2 = new long[0];
//        System.out.println(MyArrays.toString(array2));
//    }

//    public static void main(String[] args) {
//        long[] array = new long[]{1, 2, 3, 4, 5, 6, 7, 8};
//        System.out.println(MyArrays.toString(MyArrays.copyOf(array, 0)));
//        System.out.println(MyArrays.toString(MyArrays.copyOf(array, 1)));
//        System.out.println(MyArrays.toString(MyArrays.copyOf(array, 20)));
//        System.out.println(MyArrays.toString(MyArrays.copyOf(array, -1)));
//    }

//    public static void main(String[] args) {
//        long[] original = new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
//        System.out.println(Arrays.toString(MyArrays.copyOfRange(original, 0, 0)));
//        System.out.println(Arrays.toString(MyArrays.copyOfRange(original, 0, 3)));
//        System.out.println(Arrays.toString(MyArrays.copyOfRange(original, 1, 1)));
//        System.out.println(Arrays.toString(MyArrays.copyOfRange(original, 1, 3)));
//        System.out.println(Arrays.toString(MyArrays.copyOfRange(original, 0, 7)));
//        System.out.println(Arrays.toString(Arrays.copyOfRange(original, 1, 1)));
//    }

//    public static void main(String[] args) {
//        long[] original = new long[]{9, 23, 4, 5, 123, 1, -32, -32, 0};
//        System.out.println(MyArrays.toString(MyArrays.bubbleSort(original)));
//    }

    public static void main(String[] args) {
        long[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        // -1, 10 应该返回 -1
        // [1, 9] 返回 [0, 8]
        for (long target = -1; target <= 10; target++) {
            System.out.println(MyArrays.binarySearch(array, target));
        }
    }
}
