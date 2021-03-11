package leetcode.p21;

import leetcode.ListNode;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode last = new ListNode(-1);   // 新链表的最后一个结点
        ListNode newHead = last;

        ListNode c1 = l1;
        ListNode c2 = l2;

        while (c1 != null && c2 != null) {
            if (c1.val <= c2.val) {
                last.next = c1;
                c1 = c1.next;
            } else {
                last.next = c2;
                c2 = c2.next;
            }

            last = last.next;
        }

        if (c1 != null) {
            last.next = c1;
        } else {
            last.next = c2;
        }

        return newHead.next;
    }
}
