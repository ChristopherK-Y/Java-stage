package leetcode.p_138;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Solution2 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        for (Node cur = head; cur != null; cur = cur.next.next) {
            Node node = new Node(cur.val);

            node.next = cur.next;
            cur.next = node;
        }

        for (Node oldCur = head; oldCur != null; oldCur = oldCur.next.next) {
            Node newCur = oldCur.next;

            Node oldRandom = oldCur.random;
            if (oldRandom == null) {
                newCur.random = null;
            } else {
                Node newRandom = oldRandom.next;
                newCur.random = newRandom;
            }
        }

        Node newHead = head.next;
        Node oldCur = head;
        while (oldCur != null) {
            Node newCur = oldCur.next;

            oldCur.next = newCur.next;
            if (newCur.next != null) {
                newCur.next = newCur.next.next;
            }

            oldCur = oldCur.next;
        }

        return newHead;
    }
}
