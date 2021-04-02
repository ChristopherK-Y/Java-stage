import java.util.Arrays;

public class ObjectHeapOperations {
    public static void shiftDown(Person[] array, int size, int index) {
        while (true) {
            int leftIndex = 2 * index + 1;
            if (leftIndex >= size) {
                return;
            }

            int rightIndex = leftIndex + 1;
            int minIndex = leftIndex;
            if (rightIndex < size) {
                int r = array[rightIndex].compareTo(array[leftIndex]);
                if (r < 0) {
                    minIndex = rightIndex;
                }
            }

            int r = array[index].compareTo(array[minIndex]);
            if (r <= 0) {
                return;
            }

            Person t = array[index];
            array[index] = array[minIndex];
            array[minIndex] = t;

            index = minIndex;
        }
    }

    public static void createHeap(Person[] array, int size) {
        for (int i = (size - 2) / 2; i >= 0; i--) {
            shiftDown(array, size, i);
        }
    }

    public static void main(String[] args) {
        // 假定 Person 实现了 Comparable，并且满足我们的需要
        Person[] array = {
                new Person("A", 39),
                new Person("B", 18),
                new Person("C", 100),
                new Person("D", 10),
                null, null
        };
        int size = 4;

        createHeap(array, size);

        System.out.println(Arrays.toString(array));
    }
}
