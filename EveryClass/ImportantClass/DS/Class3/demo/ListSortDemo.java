package demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSortDemo {
    private static class IntegerComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.intValue() - o1.intValue();
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(5);
        list.add(2);
        list.add(7);
        list.add(3);
//
//        System.out.println(list);
//        list.sort(new IntegerComparator());
//        System.out.println(list);

        // Collection 代表集合
        // Collections 放的主要是给集合对象用的常见方法
//        Collections.sort(list, new IntegerComparator());
//        System.out.println(list);
    }
}
