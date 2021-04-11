package hashtablev1;

import com.sun.webkit.graphics.WCFontCustomPlatformData;

import java.util.Random;

// key 不允许重复
public class MyHashTable {
    // 1. 维护数组(元素类型是链表）
    private Node[] array;
    // 2. 有效元素个数
    private int size;

    public MyHashTable() {
        array = new Node[3];
        size = 0;
    }

    private int hashFunction(int key) {
        if (key < 0) {
            throw new RuntimeException("不支持 key < 0。");
        }
        return key % array.length;
    }

    // 平均: O(1)  最坏: O(n)
    public void insert(int key) {
        // 1. 找到下标
        int index = hashFunction(key);
        // 2. 判断是否存在（key 不能重复）
        for (Node cur = array[index]; cur != null; cur = cur.next) {
            if (cur.key == key) {
                throw new RuntimeException("key 不允许重复。" + key);
            }
        }
        // 3. 插入到链表中（头插/尾插都行）
        // 采用头插方式
        Node node = new Node(key);
        node.next = array[index];
        array[index] = node;

        size++;

        // 考虑负载因子
        if (1.0 * size / array.length > 0.75) {
            grow();
        }
    }

    private void grow() {
        Node[] newArray = new Node[array.length * 2];
        // 遍历哈希表的所有元素，重新计算 index
        for (int i = 0; i < array.length; i++) {
            Node cur = array[i];
            while (cur != null) {
                int index = cur.key % newArray.length;
                Node next = cur.next;

                cur.next = newArray[index];
                newArray[index] = cur;

                cur = next;
            }
        }
        array = newArray;
    }

    // 平均: O(1)  最坏: O(n)
    public boolean remove(int key) {
        // 1. 找到下标
        int index = hashFunction(key);
        // 2. 在链表中找到对应的结点删除
        // 前驱结点/头结点没有前驱
//        Node cur = array[index];
//        Node prev = null;
//        while (cur != null) {
//            if (cur.key == key) {
//                if (prev == null) {
//                    array[index] = cur.next;
//                } else {
//                    prev.next = cur.next;
//                }
//                return true;
//            }
//            prev = cur;
//            cur = cur.next;
//        }
//        return false;

        if (array[index] == null) {
            return false;
        }

        if (array[index].key == key) {
            array[index] = array[index].next;
            size--;
            return true;
        }

        // 链表不为空 && 头节点不是
        Node prev = array[index];
        while (prev.next != null) {
            if (prev.next.key == key) {
                prev.next = prev.next.next;
                size--;
                return true;
            }

            prev = prev.next;
        }

        return false;
    }

    // 平均: O(1)  最坏: O(n)
    public boolean find(int key) {
        // 1. 根据哈希函数，计算出合法下标
        int index = hashFunction(key);

        // 2. 在 array[index] 这条链表中，遍历查找 key 是否存在
        for (Node cur = array[index]; cur != null; cur = cur.next) {
            if (cur.key == key) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Random random = new Random(20210411);
        MyHashTable hashTable = new MyHashTable();
        hashTable.insert(1);
        hashTable.remove(1);


        System.out.println(hashTable.size);

    }
}
