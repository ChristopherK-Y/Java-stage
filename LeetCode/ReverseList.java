package NowCoder;

//https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;//当前节点的前驱节点
        ListNode cur = head;//当前节点
        while(cur != null){//典型的遍历整个链表
            ListNode next = cur.next;//因为待会要修改cur.next 所以，cur.next就无法找到了，这里先把他给保存下来
            cur.next = prev;//cur.next指向他的前一个节点
            prev = cur;//前驱节点后移
            cur = next;//当前节点后移
        }
        return prev;//最后一步，cur指向null，prev指向最后一个节点，所以需要返回prev
    }
}
