package use_tree_set;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Demo {
    public static void main(String[] args) {
        // Integer 具备 Comparable 的能力
        Set<Integer> set = new TreeSet<>();

        set.add(1);
        set.add(7);
        set.add(9);
        set.add(2);
        set.add(6);

        System.out.println(set);
        System.out.println(set.add(2));
        System.out.println(set);

        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        for (Integer i : set) {
            System.out.println(i);
        }

        System.out.println(set.contains(6));
        System.out.println(set.contains(12));

        TreeSet<Integer> treeSet = (TreeSet<Integer>) set;
        // 1 2 6 7 9
        System.out.println(treeSet.ceiling(3));
        System.out.println(treeSet.higher(3));

        System.out.println(treeSet.floor(3));
        System.out.println(treeSet.lower(3));

        System.out.println(treeSet.first());
        System.out.println(treeSet.last());
    }
}
