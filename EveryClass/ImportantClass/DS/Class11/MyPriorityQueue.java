import java.util.Comparator;

public class MyPriorityQueue {
    // 不考虑扩容处理
    private String[] array = new String[100];
    private int size = 0;
    private Comparator<String> comparator;

    public MyPriorityQueue() {
        this.comparator = null;
    }

    public MyPriorityQueue(Comparator<String> comparator) {
        this.comparator = comparator;
    }

    public void add(String e) {
        array[size++] = e;
        shiftUp(size - 1);
    }

    private void shiftUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            int r = compare(index, parentIndex);
            if (r <= 0) {
                return;
            }

            String t = array[index];
            array[index] = array[parentIndex];
            array[parentIndex] = t;

            index = parentIndex;
        }
    }

    private int compare(int i, int j) {
        int r;
        if (comparator != null) {
            r = comparator.compare(array[j], array[i]);
        } else {
            r = array[j].compareTo(array[i]);
        }
        return r;
    }

    // O(log(n))
    public String remove() {
        // size > 0
        String e = array[0];
        array[0] = array[size - 1];
        size--;

        shiftDown(0);

        return e;
    }

    private void shiftDown(int index) {
        while (true) {
            int leftIndex = 2 * index + 1;
            if (leftIndex >= size) {
                return;
            }

            int minIndex = leftIndex;
            int rightIndex = leftIndex + 1;
            if (rightIndex < size) {
                int r = compare(leftIndex, rightIndex);

                if (r < 0) {
                    minIndex = rightIndex;
                }
            }

            int r = compare(minIndex, index);
            if (r <= 0) {
                return;
            }

            String t = array[index];
            array[index] = array[minIndex];
            array[minIndex] = t;

            index = minIndex;
        }
    }

    public String element() {
        // size > 0
        return array[0];
    }

    public static void main(String[] args) {
//        MyPriorityQueue queue = new MyPriorityQueue();
//        queue.add("C");
//        queue.add("B");
//        queue.add("D");
//        queue.add("A");

        MyPriorityQueue queue = new MyPriorityQueue(new PriorityQueueDemo.TianGanComparator());

        queue.add("丙");
        queue.add("甲");
        queue.add("丁");
        queue.add("乙");

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }
}
