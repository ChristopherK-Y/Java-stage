import java.util.Arrays;

public class HeapSort {
    public static void heapSort(long[] array) {
        // 1. 建大堆
        createBigHeap(array);

        // 2. 开启循环 —— 每次循环：找到最大的数交换，向下调整
        for (int i = 0; i < array.length - 1; i++) {
            // 无序区间：[0, array.length - i)
            // 最大的数，一定在 [0]
            // 无序区间的最后一个数，一定在 [array.length - i - 1]
            swap(array, 0, array.length - i - 1);
            // 无序区间：[0, array.length - i - 1)
            // 向下调整
            shiftDown(array, array.length - i - 1, 0);
        }
    }

    public static void main(String[] args) {
        long[] array = { 9, 5, 2, 7, 3, 8, 6, 4, 0, 1 };
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void swap(long[] array, int i, int j) {
        long t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    // O(log(n))
    public static void shiftDown(long[] array, int size, int index) {
        while (true) {
            int leftIndex = 2 * index + 1;
            if (leftIndex >= size) {
                return;
            }

            int rightIndex = leftIndex + 1;
            int maxIndex = leftIndex;
            if (rightIndex < size && array[rightIndex] > array[leftIndex]) {
                maxIndex = rightIndex;
            }

            if (array[index] >= array[maxIndex]) {
                return;
            }

            long t = array[index];
            array[index] = array[maxIndex];
            array[maxIndex] = t;

            index = maxIndex;
        }
    }

    // O(n * log(n))   实际是 O(n)
    public static void createBigHeap(long[] array) {
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            shiftDown(array, array.length, i);
        }
    }
}
