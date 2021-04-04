import java.util.Arrays;
import java.util.Random;

public class TestSort {
    private static Random random = new Random(20210404);

    private static long[] buildReversedArray(int size) {
        long[] array = buildSortedArray(size);
        for (int i = 0; i < size / 2; i++) {
            Swap.swap(array, i, size - 1 - i);
        }
        return array;
    }

    private static long[] buildSortedArray(int size) {
        long[] array = buildRandomArray(size);
        Arrays.sort(array);

        return array;
    }

    private static long[] buildRandomArray(int size) {
        long[] array = new long[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(2 * size);
        }

        return array;
    }

    public static void main0(String[] args) {
        // 返回当前时间，表示为以毫秒为单位的时间戳
        // 时间戳：从某个固定时间（好像是：1970-01-01）到当前经过的毫秒数
        //long timestamp = System.currentTimeMillis();

        // JVM 中执行速度是越来越快的，所以需要预热下（热身）
        for (int i = 0; i < 10; i++) {
            long[] notUsed = buildRandomArray(1_0000);
            Sort.insertSort(notUsed);
            Sort.selectSort(notUsed);
            Sort.bubbleSort(notUsed);
        }

        // 开始真正的测试
        long[] array = buildReversedArray(20_0000);
        long start = System.currentTimeMillis();
        Sort.heapSort(array);
        long end = System.currentTimeMillis();

        double s = (end - start) / 1000.0;

        System.out.println(s);
    }

    public static void main(String[] args) {
        long[] arr1 = buildRandomArray(14);
        long[] arr2 = arr1.clone(); // .clone() 是把对象完全复制了一份

        QuickSort.quickSort(arr1);
        //Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr1));

        //System.out.println(Arrays.equals(arr1, arr2));
    }

    public static void main2(String[] args) {
        long[] array = { 9, 5, 2, 7, 3, 0, 1, 8, 6, 4 };

        // Sort.insertSort(array);
        // Sort.selectSort(array);
        Sort.bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
