import java.util.Arrays;

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

    private static void merge(long[] array, int from, int mid, int to) {
        // 合并 [from, mid) 和 [mid, to) 的两个有序区间
        int size = to - from;
        long[] extra = new long[size];
        int k1 = from;
        int k2 = mid;
        int k3 = 0;

        // 两个区间中还各自有元素，选择出小的放到 extra 中
        while (k1 < mid && k2 < to) {
            if (array[k1] <= array[k2]) {   // 加等号，保证稳定性
                extra[k3++] = array[k1++];
            } else {
                extra[k3++] = array[k2++];
            }
        }

        // 再把剩余的元素复制到 extra 中
        if (k1 < mid) {
            while (k1 < mid) {
                extra[k3++] = array[k1++];
            }
        } else {
            while (k2 < to) {
                extra[k3++] = array[k2++];
            }
        }

        // 把所有的元素从 extra 复制回 array 中
        for (int i = 0; i < size; i++) {
            array[from + i] = extra[i];
        }
    }

    public static void main(String[] args) {
        long[] array = { 9, 7, 1, 3, 5, 8, 2, 4, 0, 6 };
        mergeSort(array);

        System.out.println(Arrays.toString(array));
    }
}
