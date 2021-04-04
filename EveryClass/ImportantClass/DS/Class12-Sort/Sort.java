public class Sort {
    /*
    情况分为最好/平均/最坏
    最好：有序
    最坏：逆序

    时间复杂度：
    最好：O(n) 执行一次冒泡过程，发现数组有序，排序结束
    平均/最坏：O(n^2)

    空间复杂度：
    O(1)

    稳定性：具备稳定性
     */
    public static void bubbleSort(long[] array) {
        // 要排好整个数组，一共需要多少次冒泡过程
        for (int i = 0; i < array.length - 1; i++) {
            // 无序区间：[0, array.length - i) 元素个数 array.length - i

            boolean sorted = true;

            // 内部的循环整体，表示一次冒泡过程
            // 冒泡过程：
            // 无序区间的相邻的两个元素，需要两两比较一次
            for (int j = 0; j < array.length - i - 1; j++) {
                // 永远保证，相邻两个元素，最大的在后边
                if (array[j] > array[j + 1]) {  // 不加等号，具备稳定性
                    Swap.swap(array, j, j + 1);
                    sorted = false;
                }
            }

            if (sorted) {
                return;
            }
        }
    }

    /*
    不区分情况

    时间复杂度: O(n^2)
    空间复杂度: O(1)
    稳定性: 不具备稳定性
     */
    public static void selectSort(long[] array) {
        // 要排好整个数组，一共需要多少次选择过程
        for (int i = 0; i < array.length - 1; i++) {
            // 无序区间：[0, array.length - i) 元素个数 array.length - i

            // 内部的循环整体，遍历无序区间，找到最大的元素的过程 => 最大元素所在的下标
            int maxElementIdx = -1;
            for (int j = 0; j < array.length - i; j++) {
                if (maxElementIdx == -1 || array[j] > array[maxElementIdx]) {
                    maxElementIdx = j;
                }
            }

            // 交换，最大的元素 和 无序区间最后一个元素的位置
            // 要交换，需要最大元素的下标，和最后一个元素的下标
            Swap.swap(array, maxElementIdx, array.length - i - 1);
        }
    }

    /*
    情况分为最好/平均/最坏
    最好：有序
    最坏：逆序

    时间复杂度：
    最好：O(n) 每次插入过程，只需要一次比较
    平均/最坏：O(n^2)

    空间复杂度：
    O(1)

    稳定性：具备稳定性
     */
    public static void insertSort(long[] array) {
        for (int i = 1; i < array.length; i++) {
            long toInsert = array[i];
            int j;
            for (j = i - 1; j >= 0 && toInsert < array[j]; j--) {  // 不加等号，具备稳定性
                array[j + 1] = array[j];
            }
            array[j + 1] = toInsert;
        }
    }

    /*
    时间复杂度：
    平均时间复杂度：O(n ^ 1.4 - 1.5)

    空间复杂度：
    O(1)

    稳定性： 不具备稳定性
     */
    public static void shellSort(long[] array) {
        int group = array.length / 2;
        while (true) {
            groupInsertSort(array, group);
            if (group == 1) {
                // 只有 1 组，并且已经完成排序时，停止循环
                return;
            }
            group = group / 2;
        }
    }

    private static void groupInsertSort(long[] array, int group) {
        for (int i = group; i < array.length; i++) {
            long toInsert = array[i];
            int j;
            for (j = i - group; j >= 0 && toInsert < array[j]; j -= group) {
                array[j + group] = array[j];
            }
            array[j + group] = toInsert;
        }
    }

    public static void insertSort1(long[] array) {
        // 要排好整个数组，一共需要多少次选择过程
        for (int i = 1; i < array.length; i++) {
            // 有序区间：[0, i)
            // 待插入的元素：无序区间的第一个元素
            long toInsert = array[i];

            // 在有序区间内查找要插入的位置 —— 从后往前遍历查找
            // 有序区间反向表述: [i - 1, 0]
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (toInsert >= array[j]) {
                    break;
                }
            }
            int toInsertIdx = j + 1;

            // 把元素插入到合适的位置
            for (int k = i - 1; k >= toInsertIdx; k--) {
                array[k + 1] = array[k];
            }

            array[toInsertIdx] = toInsert;
        }
    }

    private static void shiftDown(long[] array, int size, int index) {
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            if (left >= size) {
                return;
            }

            int max = left;
            if (right < size && array[right] > array[left]) {
                max = right;
            }

            if (array[index] >= array[max]) {
                return;
            }

            Swap.swap(array, index, max);

            index = max;
        }
    }

    private static void createBigHeap(long[] array) {
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            shiftDown(array, array.length, i);
        }
    }


    /*
    不区分情况

    时间复杂度: O(n * log(n))
    空间复杂度: O(1)
    稳定性: 不具备稳定性
     */
    public static void heapSort(long[] array) {
        createBigHeap(array);

        for (int i = 0; i < array.length - 1; i++) {
            // 无序区间：[0, array.length - i)
            Swap.swap(array, 0, array.length - i - 1);
            // 无序区间：[0, array.length - i - 1) 元素个数 array.length - i - 1

            shiftDown(array, array.length - i - 1, 0);
        }
    }
}
