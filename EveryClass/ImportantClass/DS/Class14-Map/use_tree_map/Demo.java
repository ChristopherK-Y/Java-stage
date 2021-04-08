package use_tree_map;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Demo {
    public static void main(String[] args) {
        // 学号：姓名列表
        // 要求 key 的类型具备比较能力（Integer）
        Map<Integer, String> map = new TreeMap<>();

        map.put(2, "B");
        map.put(1, "A");
        map.put(3, "C");

        // O(n)
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
        }

        // O(n * log(n))
        for (Integer key : map.keySet()) {
            String value = map.get(key);
        }

//        for (Map.Entry<Integer, String> entry : map.entrySet()) {
////            Integer key = entry.getKey();
////            String value = entry.getValue();
////            System.out.println(key + " = " + value);
//            entry.setValue("Hello");
//        }
//        System.out.println(map);

//        for (String value : map.values()) {
//            System.out.println(value);
//        }

//        for (Integer key : map.keySet()) {
//            System.out.println(key);
//        }
//
//        System.out.println(map);
//
//        System.out.println(map.get(7));
//        System.out.println(map.getOrDefault(7, "没这个人"));
//        System.out.println(map);
//
//        System.out.println(map.put(3, "A"));
//        System.out.println(map);
    }
}
