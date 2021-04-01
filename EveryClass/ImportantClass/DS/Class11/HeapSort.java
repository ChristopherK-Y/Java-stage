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
}
