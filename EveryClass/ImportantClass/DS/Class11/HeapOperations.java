import java.util.Arrays;

public class HeapOperations {
    // O(log(n))
    public static void shiftDown(long[] array, int size, int index) {
        while (true) {
            int leftIndex = 2 * index + 1;
            if (leftIndex >= size) {
                return;
            }

            int rightIndex = leftIndex + 1;
            int minIndex = leftIndex;
            if (rightIndex < size && array[rightIndex] < array[leftIndex]) {
                minIndex = rightIndex;
            }

            if (array[index] <= array[minIndex]) {
                return;
            }

            long t = array[index];
            array[index] = array[minIndex];
            array[minIndex] = t;

            index = minIndex;
        }
    }

    // O(n * log(n))   实际是 O(n)
    public static void createHeap(long[] array, int size) {
        for (int i = (size - 2) / 2; i >= 0; i--) {
            shiftDown(array, size, i);
        }
    }

    public static void main(String[] args) {
        long[] array = {9, 3, 1, 4, 2, 5, 8, 3, 6, 0, 1, -1, -1};
        int size = 11;

        createHeap(array, size);

        System.out.println(Arrays.toString(array));
    }
}
