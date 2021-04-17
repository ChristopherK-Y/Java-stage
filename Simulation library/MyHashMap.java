package data_structure.hash_map;

import java.util.*;

public class MyHashMap {

    private Node[] array;//哈希表
    private int size;//元素个数

    static class Node {//内部类,节点
        public String key;
        public Integer value;
        public Node next;

        public Node(String key, Integer value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

    /**
     * 构造函数
     */
    public MyHashMap() {
        array = new Node[16];
        size = 0;
    }

    /**
     * 内部求哈希值函数
     *
     * @param key 给定的key
     * @return 返回哈希值
     */
    private int hash(String key) {
        int h;
        return key == null ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    /**
     * 添加元素
     * ①如果已经存在key,那么更新value
     * ②如果不存在key,那么增加<key,value>
     *
     * @param key   给定的key
     * @param value 给定的value
     * @return 如果是情况①,返回原来的value;如果是情况②,返回null
     */
    public Integer put(String key, Integer value) {
        int index = hash(key) & (array.length - 1);
        Node cur = array[index];
        while (cur != null) {
            if (cur.key.equals(key)) {
                Integer backUp = cur.value;
                cur.value = value;
                return backUp;
            }
            cur = cur.next;
        }
        //头插法
        Node newNode = new Node(key, value);
        newNode.next = array[index];
        array[index] = newNode;
        size++;
        expansion();
        return null;
    }

    /**
     * 删除节点函数
     *
     * @param key 给定的key
     * @return 如果删除成功, 返回被删除节点的value, 如果不存在该节点, 返回null
     */
    public Integer remove(String key) {
        int index = hash(key) & (array.length - 1);
        if (array[index].key.equals(key)) {
            Integer backUp = array[index].value;
            array[index] = array[index].next;
            size--;
            return backUp;
        }
        Node cur = array[index].next;
        Node prev = array[index];
        while (cur != null) {
            if (cur.key.equals(key)) {
                Integer backUp = cur.value;
                prev.next = cur.next;
                size--;
                return backUp;
            }
            prev = cur;
            cur = cur.next;
        }
        return null;
    }

    /**
     * 给定key,给出value
     *
     * @param key 给定的key
     * @return 如果存在该节点, 返回对应的value, 如果不存在返回null
     */
    public Integer get(String key) {
        int index = hash(key) & (array.length - 1);
        Node cur = array[index];
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur.value;
            }
            cur = cur.next;
        }
        return null;
    }

    /**
     * 替换给定key的value
     * 如果找到了key,那么替换value
     *
     * @param key   给定的key
     * @param value 给定的value
     * @return 如果找到了key, 返回原来的value, 如果没有找到, 返回null
     */
    public Integer replace(String key, Integer value) {
        int index = hash(key) & (array.length - 1);
        Node cur = array[index];
        while (cur != null) {
            if (cur.key.equals(key)) {
                Integer backUp = cur.value;
                cur.value = value;
                return backUp;
            }
            cur = cur.next;
        }
        return null;
    }

    /**
     * 是否存在该节点
     *
     * @param key 给定的key
     * @return 如果存在, 返回true, 如果不存在, 返回false
     */
    public boolean containsKey(String key) {
        return get(key) != null;
    }

    /**
     * 是否存在节点
     *
     * @param value 给定的value
     * @return 如果存在, 返回true, 如果不存在, 返回false
     */
    public boolean containsValue(Integer value) {
        for (Node oneBucket : array) {
            Node cur = oneBucket;
            while (cur != null) {
                if (cur.value.equals(value)) {
                    return true;
                }
                cur = cur.next;
            }
        }
        return false;
    }

    /**
     * 内部扩容函数,如果存在的元素/容量 >= 0.75
     */
    private void expansion() {
        if ((double) size / array.length >= 0.75) {
            Node[] newArray = new Node[array.length * 2];
            for (Node oneBucket : array) {
                Node cur = oneBucket;
                while (cur != null) {
                    int index = hash(cur.key) & (newArray.length - 1);
                    Node next = cur.next;
                    cur.next = newArray[index];
                    newArray[index] = cur;
                    cur = next;
                }
            }
            array = newArray;
        }
    }

    /**
     * 返回HashMap中所有的key,以set的方式
     *
     * @return 返回set
     */
    public Set<String> keySet() {
        Set<String> set = new HashSet<>();
        for (Node oneBucket : array) {
            Node cur = oneBucket;
            while (cur != null) {
                set.add(cur.key);
                cur = cur.next;
            }
        }
        return set;
    }

    /**
     * 返回HashMap中所有的value,以Collection的方式
     *
     * @return 返回Collection
     */
    public Collection<Integer> values() {
        Collection<Integer> collection = new ArrayList<>(size);
        for (Node oneBucket : array) {
            Node cur = oneBucket;
            while (cur != null) {
                collection.add(cur.value);
                cur = cur.next;
            }
        }
        return collection;
    }

    /**
     * 返回HashMap中<key,value>对的个数
     *
     * @return 返回个数
     */
    public int size() {
        return size;
    }

    /**
     * HashMap是否为空
     *
     * @return true/false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 清空Hash Map
     */
    public void clear() {
        if (array != null && size > 0) {
            size = 0;
            Arrays.fill(array, null);
        }
    }
}
