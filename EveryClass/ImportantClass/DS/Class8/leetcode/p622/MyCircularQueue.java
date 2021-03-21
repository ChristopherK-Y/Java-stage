package leetcode.p622;

public class MyCircularQueue {
    private int[] array;
    private int frontIndex;
    private int rearIndex;
    private int size;

    public MyCircularQueue(int k) {
        array = new int[k];
        frontIndex = 0;
        rearIndex = 0;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        array[rearIndex] = value;
        rearIndex = (rearIndex + 1) % array.length;
        size++;

        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        frontIndex = (frontIndex + 1) % array.length;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return array[frontIndex];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }

        int index = (rearIndex - 1 + array.length) % array.length;
        return array[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }
}
