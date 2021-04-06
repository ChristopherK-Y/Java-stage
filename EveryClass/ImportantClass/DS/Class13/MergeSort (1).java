public class MergeSort {
    public static void mergeSort(long[] array) {
        mergeSortRange(array, 0, array.length);
    }

    // [from, to)
    private static void mergeSortRange(long[] array, int from, int to) {
        int size = to - from;
        if (size <= 1) {
            return;
        }

        int mid = from + (to - from) / 2;
        // [from, mid) 和 [mid, to)

        mergeSortRange(array, from, mid);
        mergeSortRange(array, mid, to);

        // 执行合并两个有序区间
        merge(array, from, mid, to);
    }
}
