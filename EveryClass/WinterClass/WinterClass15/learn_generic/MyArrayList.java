package learn_generic;

public class MyArrayList<E> {
    private E[] array;  // 保存元素的数组
    private int size;   // 已经保存的元素个数

    public void add(E element) {
        // 把 element 放入 array 中
        // 并且 size + 1
    }

    public static void main(String[] args) {
        // 完整版本
        {
            MyArrayList<String> list = new MyArrayList<String>();
            list.add("hello");
        }

        {
            MyArrayList<Integer> list = new MyArrayList<Integer>();
            list.add(13);
        }

//        {
//            MyArrayList<int> list = new MyArrayList<int>();
//            list.add(13);
//        }

        {
            // 前面的部分不能省略
            // 后边的部分，可以经过类型推导后省略
            MyArrayList<String> list = new MyArrayList<>();
            list.add("hello");
        }
    }
}
