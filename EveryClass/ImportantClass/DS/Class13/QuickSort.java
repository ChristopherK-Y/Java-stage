import java.util.Arrays;

public class QuickSort {
    public static void quickSort(long[] array) {
        quickSortRange(array, 0, array.length - 1);
    }

    // 待排序区间，是 array 的 从 from 到 to 位置，包含 from 和 to 的位置
    private static void quickSortRange(long[] array, int from, int to) {
        int size = to - from + 1;
        if (size <= 1) {
            return;
        }

        int pivotIdx = partition(array, from, to);
        // [from, pivotIdx - 1]
        quickSortRange(array, from, pivotIdx - 1);
        // [pivotIdx + 1, to]
        quickSortRange(array, pivotIdx + 1, to);
    }

    private static int partition(long[] array, int from, int to) {
        long pivot = array[from];
        int left = from;
        int right = to;

        while (left < right) {
            while (left < right && array[right] >= pivot) {
                right--;
            }

            array[left] = array[right];

            while (left < right && array[left] <= pivot) {
                left++;
            }

            array[right] = array[left];
        }

        array[left] = pivot;

        return left;
    }

    public static void main(String[] args) {
        long[] array = { 9, 5, 2, 7, 3, 6, 8, 1, 4 };
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
