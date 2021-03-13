package NowCoder;

//https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035

import java.util.ArrayList;

public class PrintListFromTailToHead {
    ArrayList<Integer> ans = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode == null){
            return new ArrayList<Integer>();
        }
        if (listNode.next != null) {
            printListFromTailToHead(listNode.next);
        }
        ans.add(listNode.val);
        return ans;
    }
}
