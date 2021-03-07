import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        // 定义一个元素类型是 String 的顺序表
        ArrayList<String> list = new ArrayList<>(); // 一开始是一个空的顺序表

//        list.add("我");  // 由于元素类型是 String 类型，所以元素（参数）类型是String
//        list.add("你");
//        list.add("他");
//
//        System.out.println(list);

//        // 合法下标: [0, 0]
//        list.add(0, "我");   // 下标 0 是否合法？
//
//        // 合法下标: [0, 1]
//        list.add(0, "你");
//
//        // 合法下标: [0, 2]
//        list.add(0, "他");
//
//        System.out.println(list);

//        list.add("我");
//        list.add(0, "你");
//        list.add(1, "他");
//        list.add(1, "谁");
//        list.add(0, "不是");
//        list.add(3, "就是");
//
//        System.out.println(list);
//
//        list.add("我");
//        // size = 1, [0, 1]
//        list.add(3, "你");   // java.lang.IndexOutOfBoundsException: Index: 3, Size: 1


        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");
        list.add("B");
        System.out.println(list.size());    // 7
        System.out.println(list.isEmpty()); // false
        list.clear();
        System.out.println(list.size());    // 0
        System.out.println(list.isEmpty()); // true
//        System.out.println(list);
//
//        System.out.println(list.contains("A")); // true
//        System.out.println(list.contains("H")); // false
//        System.out.println(list.indexOf("B"));  // 1
//        System.out.println(list.indexOf("H"));  // -1
//        System.out.println(list.lastIndexOf("B"));  // 6
//        System.out.println(list.lastIndexOf("H"));  // -1

//        System.out.println(list.get(0));    // A
//        System.out.println(list.get(1));    // B
//        System.out.println(list);       // A B C D E F

//        System.out.println(list.set(0, "我"));   // A
//        System.out.println(list.set(1, "你"));   // B
//        System.out.println(list);   // 我 你 C D E F

//        list.remove(6); // java.lang.IndexOutOfBoundsException: Index: 6, Size: 6

//        boolean b = list.remove("B");
//        System.out.println(list);   // A C D B B
//        System.out.println(b);      // true

        // size = 6
//        String remove = list.remove(2);
//        System.out.println(list);   // A B D E F
//        System.out.println(remove); // C

//        boolean e = list.remove("E");
//        System.out.println(list);   // A B C D F
//        System.out.println(e);      // true

//        boolean h = list.remove("H");
//        System.out.println(list);   // A B C D E F
//        System.out.println(h);  // false
    }
}
