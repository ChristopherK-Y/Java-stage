package leetcode.p160;

import base.ListNode;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = getCount(headA);
        int countB = getCount(headB);

        ListNode curA = headA;
        ListNode curB = headB;

        if (countA > countB) {
            for (int i = 0; i < countA - countB; i++) {
                curA = curA.next;
            }
        } else if (countB > countA) {
            for (int i = 0; i < countB - countA; i++) {
                curB = curB.next;
            }
        }

        while (curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }

        return curA;
    }
}
