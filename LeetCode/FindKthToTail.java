package NowCoder;

//https://www.nowcoder.com/practice/886370fe658f41b498d40fb34ae76ff9
public class FindKthToTail {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pHead ListNode类
     * @param k     int整型
     * @return ListNode类
     */
    public ListNode findKthToTail(ListNode pHead, int k) {
        if(pHead == null){//如果这是一个空链表，那么直接返回null即可
            return null;
        }
        //统计链表的长度
        int length = 0;
        ListNode cur = pHead;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        //如果链表的长度比要找的倒数数字还小，那么一定到不到，直接返回null即可
        if(length < k){
            return null;
        }
        //jump代表要找到倒数第k个，就要从头跳多少下
        int jump = length - k;
        cur = pHead;
        //for循环跳就好了
        for (int i = 0; i < jump; i++) {
            cur = cur.next;
        }
        //返回最后跳到的当前cur指向的节点
        return cur;
    }
}
