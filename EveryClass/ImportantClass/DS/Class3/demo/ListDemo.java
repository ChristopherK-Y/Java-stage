package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//
//        list.add("我");  // [0]
//        list.add("你");  // [1]
//        list.add("他");  // [2]
//
//        //System.out.println(list);
//
//        List<String> strings = list.subList(1, 2);  // 包含 [1]，不含 [2]
//        System.out.println(strings);


        List<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        list1.add("C");

        Object[] objects = list1.toArray();
        System.out.println(Arrays.toString(objects));
        String[] strings = list1.toArray(new String[0]);
        System.out.println(Arrays.toString(strings));

//        List<String> list2 = new ArrayList<>();
//        list2.add("A");
//        list2.add("1");
//        list2.add("2");
//
//        boolean b = list1.retainAll(list2);
//        System.out.println(b);
//        System.out.println(list1);
    }
}
