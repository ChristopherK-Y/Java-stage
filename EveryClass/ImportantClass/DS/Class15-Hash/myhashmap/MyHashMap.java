package myhashmap;

import java.util.*;

// 所有 key 都不允许为 null
public class MyHashMap {
    private Node[] array;
    private int size;

    public MyHashMap() {
        array = new Node[16];
        size = 0;
    }

    public Integer get(String key) {
        // 1. key -> int
        int hash = key.hashCode();
        // 2. int -> 合法的下标
        int index = hash % array.length;

        for (Node cur = array[index]; cur != null; cur = cur.next) {
            if (cur.key.equals(key)) {
                return cur.value;
            }
        }

        return null;
    }

    public Integer getOrDefault(String key, Integer defaultValue) {
        Integer value = get(key);
        if (value == null) {
            return defaultValue;
        }
        return value;
    }

    public Integer put(String key, Integer value) {
        int hash = key.hashCode();
        int index = hash % array.length;

        for (Node cur = array[index]; cur != null; cur = cur.next) {
            if (cur.key.equals(key)) {
                Integer v = cur.value;
                cur.value = value;
                return v;
            }
        }

        Node node = new Node(key, value);
        node.next = array[index];
        array[index] = node;
        size++;

        if (size * 1.0 / array.length > 0.75) {
            // 扩容
        }

        return null;
    }

    public Set<String> keySet() {
        Set<String> keySet = new HashSet<>();
        for (Node node : array) {
            for (Node cur = node; cur != null; cur = cur.next) {
                keySet.add(cur.key);
            }
        }
        return keySet;
    }

    public Collection<Integer> values() {
        List<Integer> valueList = new ArrayList<>();
        for (Node node : array) {
            for (Node cur = node; cur != null; cur = cur.next) {
                valueList.add(cur.value);
            }
        }
        return valueList;
    }
}
