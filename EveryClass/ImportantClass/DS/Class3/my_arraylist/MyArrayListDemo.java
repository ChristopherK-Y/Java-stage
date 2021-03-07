package my_arraylist;

public class MyArrayListDemo {
    public static void main(String[] args) {
        MyList list = new MyArrayList();
        System.out.println(list);   // []
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);   // [1, 2, 3]
        list.add(0, 100);
        list.add(0, 200);
        list.add(0, 300);
        System.out.println(list);   // [300, 200, 100, 1, 2, 3]

        Integer remove = list.remove(2);
        System.out.println(list);   // [300, 200, 1, 2, 3]
        System.out.println(remove); // 100

        boolean r = list.remove((Integer)1);    // 通过类型转换，确认调用的是 remove(Integer) 而不是 remove(int)
        System.out.println(r);      // true
        System.out.println(list);   // [300, 200, 2, 3]

        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.clear();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
    }
}
