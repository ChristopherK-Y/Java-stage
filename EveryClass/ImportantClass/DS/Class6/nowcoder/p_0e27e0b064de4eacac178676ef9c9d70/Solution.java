package nowcoder.p_0e27e0b064de4eacac178676ef9c9d70;

import base.ListNode;

public class Solution {
    public ListNode partition(ListNode pHead, int x) {
        ListNode lastA = new ListNode(-1);  // < x 的链表的尾节点
        ListNode headA = lastA;

        ListNode lastB = new ListNode(-1);  // >= x 的链表的尾结点
        ListNode headB = lastB;

        for (ListNode cur = pHead; cur != null; cur = cur.next) {
            if (cur.val < x) {
                lastA.next = cur;
                lastA = cur;    // lastA = lastA.next;
            } else {
                lastB.next = cur;
                lastB = cur;    // lastB = lastB.next;
            }
        }

        lastA.next = headB.next;
        lastB.next = null;
        return headA.next;
    }
}
