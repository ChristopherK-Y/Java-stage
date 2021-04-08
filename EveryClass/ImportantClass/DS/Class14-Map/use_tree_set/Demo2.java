package use_tree_set;

import java.util.Comparator;
import java.util.TreeSet;

public class Demo2 {
    static class C implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.age - o2.age;
        }
    }

    public static void main(String[] args) {
        TreeSet<Person> treeSet = new TreeSet<>(new C());

        Person p1 = new Person("A", 1);

        treeSet.add(p1);
        System.out.println(treeSet);

        Person p2 = new Person("B", 2);
        treeSet.add(p2);
        System.out.println(treeSet);

        Person p3 = new Person("C", 1);
        treeSet.add(p3);
        System.out.println(treeSet);
    }
}
