package nowcoder.p_529d3ae5a407492994ad2a246518148a;

import leetcode.ListNode;

public class Solution {
    public ListNode FindKthToTail2(ListNode head, int k) {
        ListNode front = head;
        ListNode back = head;

        // 先让前面的引用向后跳 k 步
        for (int i = 0; i < k; i++) {
            if (front == null) {
                return null;
            }
            front = front.next;
        }

        while (front != null) {
            front = front.next;
            back = back.next;
        }

        return back;
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        int len = length(head);
        if (len < k) {
            return null;
        }
        int step = len - k;
        ListNode cur = head;
        for (int i = 0; i < step; i++) {
            cur = cur.next;
        }
        return cur;
    }

    private int length(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            len++;
        }

        return len;
    }
}
