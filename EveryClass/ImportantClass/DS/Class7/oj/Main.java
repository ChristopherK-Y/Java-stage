package oj;

import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        // 1. 构建测试数据
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;

        // 2. 调用待测试的方法
        // reverseList(n1); 本类的静态方法
        // Solution.reverseList(n1); 其他类的静态方法
        Solution s = new Solution();
        ListNode r = s.reverseList(n1);

        // 3. 验证测试的正确性
        // 3.1 打印观察
        //System.out.println(r.toString());
        // 链表必须通过遍历进行打印
//        ListNode cur = r;
//        while (cur != null) {
//            System.out.println(cur);
//            cur = cur.next;
//        }

        // 3.2 通过代码测试
        ListNode cur = r;
        for (int i = 4; i >= 1; i--) {
            if (cur.val != i) {
                System.out.println("错误发生了");
            }

            cur = cur.next;
        }
    }
}
