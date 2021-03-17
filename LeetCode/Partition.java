package LeetCode;

//https://leetcode-cn.com/problems/partition-list/
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    ListNode() {

    }
}

public class Partition {
    /**
     * 两个指针，通过一个while把链表的所有节点，分成两类，最后连接住
     * @param head 给定链表的头
     * @param x 分割数字
     * @return 新的链表
     */
    public ListNode partition(ListNode head, int x) {
        ListNode low = new ListNode(-1);
        ListNode high = new ListNode(-1);
        ListNode newHead = low;
        ListNode highHead = high;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                low.next = cur;
                low = low.next;
            } else {
                high.next = cur;
                high = high.next;
            }
            cur = cur.next;
        }
        high.next = null;//此处可能会形成环
        low.next = highHead.next;
        return newHead.next;
    }
}
