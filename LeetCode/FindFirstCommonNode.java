package NowCoder;

//https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class FindFirstCommonNode {
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        //p1,p2两个指针，分别指向两个链表的头
        //情况如下：
        //①如果两个链表一样长，那么他们相当于从同一起点出发，那么，直接就到相交的第一个节点相遇了
        //②如果两个链表不一样长，那么当短的链表走完的时候，此时，长链表距离尾巴的距离恰好就是两个链表的长度差
        //而，下一步短链表会走到长链表的头，当长链表走到尾巴的时候，他会走向短链表的头，而此时，2个指针
        //一个指向短链表的头，一个指向长链表距离头部为两链表长度差的位置，而后，两个指针，会同时指向交点位置的节点
        //③在上面两种情况中，如果链表没有相交，那么他们最终都会指向null。
        while (p1 != p2) {
            p1 = (p1 == null ? pHead2 : p1.next);
            p2 = (p2 == null ? pHead1 : p2.next);
        }
        //最终返回p1或p2，因为他们的指向要不一样，要不就都是null
        return p1;
    }
}
