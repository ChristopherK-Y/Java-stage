import java.util.Arrays;

public class QuickSort {
    public static void quickSort(long[] array) {
        quickSortRange(array, 0, array.length - 1);
    }

    private static void quickSortRange(long[] array, int from, int to) {
        int size = to - from + 1;
        // 3. 直到，待排序区间的元素个数 <= 1
        if (size <= 1) {
            return;
        }

        // 1. 选择基准值 array[from]
        // 2. 做 partition，返回基准值跑到哪里去了 [pivotIdx]
        int pivotIdx = partition3(array, from, to);

        // 左边的区间如何表示：[from, pivotIdx - 1]
        // 右边的区间如何表示：[pivotIdx + 1, to]
        // 3. 分别对左右两个小区间按照相同的方式处理（递归调用）
        quickSortRange(array, from, pivotIdx - 1);
        quickSortRange(array, pivotIdx + 1, to);
    }

    private static int partition1(long[] array, int from, int to) {
        long pivot = array[from];
        int left = from;
        int right = to;

        // 只要还有未比较的元素，循环就得继续
        // (left, right] 的元素个数 right - left > 0
        while (left < right) {
            // 因为我们基准值在左边，所以先走右边
            while (left < right && array[right] >= pivot) {
                right--;
            }

            while (left < right && array[left] <= pivot) {
                left++;
            }

            Swap.swap(array, left, right);
        }

        Swap.swap(array, from, left);

        return left;
    }

    private static int partition2(long[] array, int from, int to) {
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

    private static int partition3(long[] array, int from, int to) {
        long pivot = array[from];
        int d = from + 1;
        for (int i = from + 1; i <= to; i++) {
            if (array[i] < pivot) {
                Swap.swap(array, d, i);
                d++;
            }
        }

        Swap.swap(array, from, d - 1);

        return d - 1;
    }

    public static void main(String[] args) {
        //long[] array = { 5, 9, 2, 7, 3, 6, 8, 4, 0 };
        long[] array = { 5, 1, 9, 2, 8, 3, 7, 4, 6 };
        //long[] array = { 5, 9, 1, 8, 2, 7, 3, 6, 4 };
        //long[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        //long[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        //long[] array = { 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        int from = 0;
        int to = 8;

        System.out.println(Arrays.toString(array));
        partition3(array, from, to);
        System.out.println(Arrays.toString(array));
    }
}
