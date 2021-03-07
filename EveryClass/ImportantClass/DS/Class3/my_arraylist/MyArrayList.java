package my_arraylist;

import java.util.Arrays;

public class MyArrayList implements MyList {
    private Integer[] array;
    private int size;

    public MyArrayList() {
        array = new Integer[16];
        size = 0;
    }

    // O(n)
    // 供内部进行容量控制
    // 这个方法一旦执行结束后，可以保证，顺序表内部的数组中，至少还可以放一个元素
    private void ensureCapacity() {
        if (size < array.length) {
            // 当前元素个数 < 容量：至少还能放一个元素
            return;
        }

        // 否则进行扩容 —— 搬家的过程
        // 1. 找到一个新的房子，一般来说，房子大小往 2 倍进行扩容（经验值）
        // 如果新房子太大，意味着很多空间在闲置，浪费了
        // 如果新房子太小，意味着需要经常扩容
        // 所以，经过经验看，扩大 2 倍相对比较合适
        // 原来的房子大小是 array.length，新的房子的大小就是 array.length * 2
        Integer[] newArray = new Integer[array.length * 2];

        // 2. 把原来房子中的东西全部搬到新房子中来
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }

        // 3. 通过发朋友圈，公布新房子的位置，老房子就可以推掉了
        this.array = newArray;  // 修改了对象中的属性，以后再操作顺序表，就操作 newArray 指向的对象了
    }

    // 数据规模 n 指的是？    元素个数（size）
    // 时间复杂度 O(1) *
    // 虽然最坏情况下，确实是 O(n)
    // 但由于扩容的机会非常少，所以，一般还是认为尾插是 O(1)
    @Override
    public boolean add(Integer e) {
        // TODO: 暂时先不考虑容量不足的情况
        ensureCapacity();   // O(n)

        array[size] = e;    // 尾插，放入元素  // O(1)  内存的随机访问就是 O(1)
                            // RAM  Random Access Memory
        size++;             // O(1)

        return true;
    }

    // 时间复杂度 O(n)
    @Override
    public void add(int index, Integer e) {
        // TODO: 暂时先不考虑容量不足的情况
        ensureCapacity();

        // 1. 判断 index 是否合法
        if (index < 0 || index > size()) {
            // 下标不合法
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        // 2. 进行插入，[index, size) 所有元素向后移一格
        for (int from = size - 1; from >= index; from--) {
            int to = from + 1;
            array[to] = array[from];
        }
        // 作业: 如果以 to 作为循环的坐标，代码怎么写？
        // 3. 把元素放入 index 位置
        array[index] = e;
        // 4. size 增加 1
        size++;
    }

    // O(n)
    @Override
    public Integer remove(int index) {
        // 1. 先考虑 index 是否合法
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        // 2. 需要再考虑顺序表是否为 Empty 的情况么？
        // 不需要。如果是 Empty，说明 size == 0，上面的 index 判断就不存在正确情况

        Integer e = array[index];
        // 1. 把 [index + 1, size - 1] 的元素，往前移一格
        for (int from = index + 1; from < size; from++) {
            int to = from - 1;
            array[to] = array[from];
        }
        // 2. 把 [size - 1] 置为 null
        array[size - 1] = null;
        // 3. size 减一
        size--;

        // 返回原来位置的元素
        return e;
    }

    // O(n)
    @Override
    public boolean remove(Integer e) {
        int i = indexOf(e);
        if (i < 0) {
            return false;
        }

        remove(i);
        return true;
    }

    // O(1)
    @Override
    public Integer get(int index) {
        // 1. 先考虑 index 是否合法
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return array[index];
    }

    // O(1)
    @Override
    public Integer set(int index, Integer e) {
        // 1. 先考虑 index 是否合法
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Integer oldE = array[index];
        array[index] = e;
        return oldE;
    }

    // O(n)
    @Override
    public boolean contains(Integer e) {
        return indexOf(e) >= 0;
    }

    // O(n)
    @Override
    public int indexOf(Integer e) {
        // 顺序表的有序 —— 元素和元素之间有次序
        // 并不意味着，元素是按照从小到大或者从大到小来排好序的
        // 所以不能用二分查找，只能遍历查找
        for (int i = 0; i < size; i++) {
            if (e.equals(array[i])) {   // 使用的是 equals 进行比较
                return i;
            }
        }

        return -1;
    }

    // O(n)
    @Override
    public int lastIndexOf(Integer e) {
        for (int i = size - 1; i >= 0; i--) {
            if (e.equals(array[i])) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public void clear() {
        Arrays.fill(array, null);
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        Integer[] toShow = Arrays.copyOf(array, size);
        // toShow.length == size
        return Arrays.toString(toShow);
    }
}
