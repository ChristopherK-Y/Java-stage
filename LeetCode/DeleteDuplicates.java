package LeetCode;

//https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode prev = new ListNode(-1);
        ListNode newHead = prev;
        prev.next = head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        while(p2 != null){
            //如果一旦找到2个连续的数字相同，那么头就不动了
            if(p1.val != p2.val){
                prev = prev.next;
                p1 = p1.next;
                p2 = p2.next;
            }else{
                while(p2 != null && p2.val == p1.val){
                    //现在去找尾巴了，尾巴为第一个不相同的值，找到之后，就把头的前驱和现在的尾巴连住
                    p2 = p2.next;
                }
                prev.next = p2;
                //头更新为新的尾巴（注：此时前驱不动）
                p1 = p2;
                if(p2 != null){
                    //尾巴后移
                    p2 = p2.next;
                }
            }
        }
        return newHead.next;
    }
}
