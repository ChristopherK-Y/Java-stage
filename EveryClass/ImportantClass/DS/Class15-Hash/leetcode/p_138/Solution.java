package leetcode.p_138;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    static class NodeComparator implements Comparator<Node> {
        // 1. 只是为了保存到 TreeMap 中，所以并不是真正关心谁先谁后的问题
        // 2. Node n1 = new Node(1);  Node n2 = new Node(1);
        //    必须保证 即使 val 相等，比较的结果也是不相同
        //   只要是不同的对象，结果一定不等
        @Override
        public int compare(Node o1, Node o2) {
            return o1.hashCode() - o2.hashCode();
        }
    }

    public Node copyRandomList(Node head) {
        Node newHead = new Node(-1);
        Node newLast = newHead;

        // 先复制链表（不处理 random）
        for (Node cur = head; cur != null; cur = cur.next) {
            Node node = new Node(cur.val);
            newLast.next = node;
            newLast = node;
        }

        // 建立映射关系
        // TODO: 解决 Node 不具备比较能力的问题
        Map<Node, Node> map = new TreeMap<>(new NodeComparator());
        Node oldCur = head;
        Node newCur = newHead.next;
        while (oldCur != null) {
            map.put(oldCur, newCur);

            oldCur = oldCur.next;
            newCur = newCur.next;
        }

        // 处理 random 的问题
        oldCur = head;
        newCur = newHead.next;
        while (oldCur != null) {
            Node oldRandom = oldCur.random;
            if (oldRandom == null) {
                newCur.random = null;
            } else {
                Node newRandom = map.get(oldRandom);
                newCur.random = newRandom;
            }

            oldCur = oldCur.next;
            newCur = newCur.next;
        }

        return newHead.next;
    }
}
