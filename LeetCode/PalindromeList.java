package NowCoder;

//https://www.nowcoder.com/questionTerminal/d281619e4b3e4a60a2cc66ea32855bfa
public class PalindromeList {
    public boolean chkPalindrome(ListNode A) {
        int length = 0;
        ListNode cur = A;
        //统计链表的长度
        while(cur != null){
            length++;
            cur = cur.next;
        }
        cur = A;
        //找到整个链表的中心点
        for(int i = 0; i < length / 2; i++){
            cur = cur.next;
        }
        ListNode mid = cur;
        ListNode prev = null;
        //逆置后半段
        while(mid != null){
            ListNode next = mid.next;
            mid.next = prev;
            prev = mid;
            mid = next;
        }
        //相当于从头和尾同时往后指
        while(prev != null && A != null){
            if(prev.val != A.val){
                return false;
            }
            prev = prev.next;
            A = A.next;
        }
        return true;
    }
}
