package NowCoder;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

import java.sql.SQLOutput;

public class ReverseKGroup {
    /**
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;//标准遍历链表程序
        boolean flag = false;//标志是否进入逆置程序
        int count = 1;//用于计数是否达到k
        ListNode nowHead = head;//记录当前的长度为k的链表的头
        ListNode lastNext;//记录当前长度为k的链表的尾的next
        ListNode noUseNode = new ListNode(-1);//无用节点，构建出了一个多的节点，用于最后的新链表返回
        ListNode nowPrev = noUseNode;//记录前一段长度为k的尾巴，即当前长度为k的链表的应当前驱节点
        while (cur != null) {
            if (count == k) {//如果计数器到达了k个节点，进入逆置程序
                lastNext = cur.next;
                cur.next = null;//此处把前k个节点的链表尾巴直接切断，方便下面进行逆置的while循环
                ListNode tempCur = nowHead;//标准链表循环，但是已有cur，所以此处为tempCur
                ListNode prev = lastNext;//第一个被逆置的节点，应当的next，即理论上的前驱节点，
                while (tempCur != null) {//标准逆置程序体
                    flag = true;//标准进入过逆置程序
                    ListNode next = tempCur.next;
                    tempCur.next = prev;
                    prev = tempCur;
                    tempCur = next;
                }
                nowPrev.next = prev;//前一段长度为k的链表的尾巴应当接住当前被逆置的头
                nowPrev = nowHead;//更新新的一段长度为k的链表的尾巴
                cur = lastNext;//更新主cur，就是之前逆置链表的下一个元素
                nowHead = lastNext;//更新主nowHead，就是之前逆置链表的下一个元素
                count = 1;//计数器重置
            } else {//计数器没有达到k个节点，cur后移，计数器+1
                cur = cur.next;
                count++;
            }
        }
        if (flag) {
            return noUseNode.next;//最后返回结果
        }
        return head;//如果从未进入过逆置程序，那么链表没有被修改过，直接返回head
    }

    public static void printList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val);
            System.out.print("->");
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        head = new ReverseKGroup().reverseKGroup(head,2);
        printList(head);
    }
}