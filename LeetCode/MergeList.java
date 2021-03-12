package NowCoder;

//https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337
public class Merge {
    public ListNode merge(ListNode list1,ListNode list2) {
        ListNode last = new ListNode(-1);//新建一个节点，那么以后的代码会很好写
        ListNode newHead = last;//定义一个头指向新链表的头
        while(list1 != null && list2 != null){//典型的遍历整个链表
            //双指针法：总是挑出来当前俩个指针指向的节点中，值最小的那一个，然后尾插进新链表
            if(list1.val <= list2.val){
                last.next = list1;
                list1 = list1.next;
            }else{
                last.next = list2;
                list2 = list2.next;
            }
            last = last.next;
        }
        //退出循环为一个链表为空了，判断一下，然后将没完的那一个接到最后就好了
        if(list1 == null){
            last.next = list2;
        }else{
            last.next = list1;
        }
        return newHead.next;//返回newHead.next,因为头节点是我们自己建的，所以……
    }
}
