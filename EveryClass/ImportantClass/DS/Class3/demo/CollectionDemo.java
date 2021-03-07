package demo;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("我");
        list.add("你");
        list.add("他");
        list.add("谁");

        Collection<String> collection = list;
        System.out.println(collection);

        for (String e : collection) {
            System.out.println(e);
        }

        collection.add("不是我");
        System.out.println(collection);
        collection.remove("你");
        System.out.println(collection);
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());
        collection.clear();
        System.out.println(collection);
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());
    }
}
