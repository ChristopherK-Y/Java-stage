package learn_generic;

import java.util.Comparator;

public class Sort {
    public static <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                // 比较 array[j] 和 array[j + 1];
                int r = array[j].compareTo(array[j + 1]);
                // 如果 array[j] > array[j + 1]，交换
                if (r > 0) {
                    T t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }
            }
        }
    }

    public static void main(String[] args) {
        Class<Sort> sortClass = Sort.class;
        Class<Search> searchClass = Search.class;

        printClass(sortClass);
        printClass(searchClass);
    }

    // Class<?> 这里是通配符
    // 使用 Class 这个泛型类，所以用通配符
    private static void printClass(Class<?> anClass) {
        System.out.println(anClass.getName());
    }
}
