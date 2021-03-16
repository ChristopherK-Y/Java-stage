package nowcoder.p_d281619e4b3e4a60a2cc66ea32855bfa;

import base.ListNode;

public class Solution {
    public boolean chkPalindrome(ListNode A) {
        ListNode middle = getMiddle(A);
        ListNode reverseHead = reverseList(middle);

        ListNode curA = A;
        ListNode curB = reverseHead;
        while (curA != null && curB != null) {
            if (curA.val != curB.val) {
                return false;
            }
            
            curA = curA.next;
            curB = curB.next;
        }
        
        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private ListNode getMiddle(ListNode head) {
        int count = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            count++;
        }

        ListNode ans = head;
        for (int i = 0; i < count / 2; i++) {
            ans = ans.next;
        }

        return ans;
    }

}
