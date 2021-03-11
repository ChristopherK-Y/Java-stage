package leetcode.p876;

import leetcode.ListNode;

public class Solution {
    private int length(ListNode head) {
        int len = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            len++;
        }
        return len;
    }
    public ListNode middleNode(ListNode head) {
        int len = length(head);
        ListNode cur = head;
        for (int i = 0; i < len / 2; i++) {
            // 往后跳 len / 2 步
            cur = cur.next;
        }
        return cur;
    }

    public ListNode middleNode2(ListNode head) {
        ListNode c1 = head;
        ListNode c2 = head;

        while (c2 != null) {
            c2 = c2.next;
            if (c2 == null) {
                break;
            }
            c2 = c2.next;

            c1 = c1.next;
        }

        return c1;
    }
}
