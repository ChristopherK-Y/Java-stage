package use_map;

import java.util.HashMap;
import java.util.HashSet;

public class Demo2 {
    public static void main(String[] args) {
        HashMap<Person, String> map = new HashMap<>();
        Person p1 = new Person("A", 1);
        Person p2 = new Person("A", 1);
        map.put(p1, "AAA");
        System.out.println(map.get(p2));
        HashSet<Person> set = new HashSet<>();
//
//        Person p1 = new Person("A", 1);
//        System.out.println(p1.hashCode());
//        set.add(p1);
//
//        Person p2 = new Person("A", 1);
//        System.out.println(p2.hashCode());
//        System.out.println(set.contains(p2));
    }
}
