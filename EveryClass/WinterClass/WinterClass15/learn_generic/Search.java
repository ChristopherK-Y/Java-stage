package learn_generic;

public class Search {
    // Type
    public static <T> int search(T[] array, T target) {
        for (int i = 0; i < array.length; i++) {
            T element = array[i];
            if (element.equals(target)) {
                return i;
            }
        }

        return -1;
    }

    // 重点掌握使用语法
    public static void main(String[] args) {
        // 完整写法
        {
            String[] array = {"hello", "world"};
            int r = Search.<String>search(array, "world");
            System.out.println(r);
        }

        {
            Integer[] array = { 1, 2, 3, 4, 5 };
            int r = Search.<Integer>search(array, 3);
            System.out.println(r);
        }

        {
            Integer[] array = { 1, 2, 3, 4, 5 };
            // 省略的写法，基于编译器有能力做类型推导
            // 编译器知道 array 是 Integer[]，知道 3 是 int OR Integer
            // 编译器可以推导出 T 就是 Integer，所以不需要我们再写一遍
            // 类型推导：Type Inference
            int r = Search.search(array, 3);
            System.out.println(r);
        }

        {
            Integer[] array = { 1, 2, 3, 4, 5 };
            // 因为在同一个类中，所以类名也省略了
            int r = search(array, 3);
            System.out.println(r);
        }

//        {
//            int[] array = {1, 2, 3, 4, 5};
//            int r = Search.<int>search(array, 3);
//            System.out.println(r);
//        }
    }
}
