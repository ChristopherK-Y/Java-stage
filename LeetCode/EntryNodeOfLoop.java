package NowCoder;

//https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4
public class EntryNodeOfLoop {
    /**
     * 1、设置快慢指针，假如有环，他们最后一定相遇。
     * 2、两个指针分别从链表头和相遇点继续出发，每次走一步，最后一定相遇与环入口。
     *
     * 证明结论2：
     * 设：
     * 链表头到环入口长度为--a
     * 环入口到相遇点长度为--b
     * 相遇点到环入口长度为--c
     * 则：相遇时
     * 快指针路程=a+(b+c)k+b ，k>=1  其中b+c为环的长度，k为绕环的圈数（k>=1,即最少一圈，不能是0圈，不然和慢指针走的一样长，矛盾）。
     * 慢指针路程=a+b
     * 快指针走的路程是慢指针的两倍，所以：
     * （a+b）*2=a+(b+c)k+b
     * 化简可得：
     * a=(k-1)(b+c)+c 这个式子的意思是： 链表头到环入口的距离=相遇点到环入口的距离+（k-1）圈环长度。其中k>=1,所以k-1>=0圈。所以两个指针分别从链表头和相遇点出发，最后一定相遇于环入口。
     *
     * @param pHead 链表的头
     * @return 返回这个循环链表的环的入口结点
     */
    public ListNode entryNodeOfLoop(ListNode pHead) {
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast != null && fast.next != null) {//保证了不发生异常（如果没有环，那么必定会发生异常）
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {//如果相遇了就退出
                break;
            }
        }
        if (fast == null || fast.next == null) {
            //应该退出上一个while有两种情况，所以这里判断一下，如果是指针指向空了，那么就是走完了，没有环存在
            return null;
        }
        //x保存第一次，在环上，快慢指针相遇的位置
        ListNode x = fast;//或 = slow
        while (pHead != x) {//让头指针和x同时走，相遇的位置就是交点的位置
            pHead = pHead.next;
            x = x.next;
        }
        //返回交点
        return x;
    }
}
