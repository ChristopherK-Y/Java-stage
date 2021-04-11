package use_hashset_hashmap;

import java.util.HashSet;

public class Demo {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        // HashSet 既不保证 key 有序，也不保证插入有序
        set.add(1);
        set.add(7);
        set.add(13);
        set.add(2);
        set.add(9);
        set.add(9999999);       // O(1)

        System.out.println(set.contains(7));    // O(1)
        System.out.println(set.remove(7));  // O(1)
    }
}
