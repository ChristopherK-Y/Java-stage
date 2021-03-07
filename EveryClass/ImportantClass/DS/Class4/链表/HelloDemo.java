public class HelloDemo {
    // 头插之后会返回新的头结点
    // 为什么要返回新的头结点呢，因为头节点在变化
    private static Node pushHead(Node head, int val) {
        Node node = new Node();
        node.val = val;
        if (head == null) {
            node.next = null;
            return node;
        } else {
            node.next = head;
            return node;
        }
    }

    private static void printLinkedListByHead(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        Node head = null;
        head = pushHead(head, 1);
        head = pushHead(head, 2);
        head = pushHead(head, 3);

        printLinkedListByHead(head);    // 3 2 1
    }

    public static void main3(String[] args) {
        Node n1 = new Node();
        Node n3 = new Node();
        Node n2 = new Node();
        Node n6 = new Node();

        n1.val = 1;
        n3.val = 3;
        n2.val = 2;
        n6.val = 6;

        n1.next = n3;
        n3.next = n2;
        n2.next = n6;
        n6.next = null;

        Node prev = n3;
        Node n100 = new Node();
        n100.val = 100;
        n100.next = prev.next;
        prev.next = n100;

        Node cur = n1;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    public static void main2(String[] args) {
        Node n1 = new Node();
        Node n3 = new Node();
        Node n2 = new Node();
        Node n6 = new Node();

        n1.val = 1;
        n3.val = 3;
        n2.val = 2;
        n6.val = 6;

        n1.next = n3;
        n3.next = n2;
        n2.next = n6;
        n6.next = null;


        Node prev = n3;
        prev.next = prev.next.next;
        Node cur = n1;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    public static void main1(String[] args) {
        Node n1 = new Node();
        Node n3 = new Node();
        Node n2 = new Node();
        Node n6 = new Node();

        n1.val = 1;
        n3.val = 3;
        n2.val = 2;
        n6.val = 6;

        n1.next = n3;
        n3.next = n2;
        n2.next = n6;
        n6.next = null;

        // 因为 n1 是第一个结点，所以我们称为头结点
        Node head = n1; // 让 head 和 n1 指向同一个结点对象
        // head 作为头结点，代表一整条链表




        // 如何 head 链表的遍历
        // 只需要打印每个元素即可

        Node cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }

        int count = 0;
        cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        System.out.println("链表长度是: " + count);

        // 暂时不考虑链表是 empty 的情况（链表中至少有一个结点）
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        System.out.println(last.val);

        // 假定 head 中至少有两个结点
        Node secondLast = head;
        while (secondLast.next.next != null) {
            secondLast = secondLast.next;
        }
        System.out.println(secondLast.val);

        // 找第 n 个结点
        // 需要向后走 n - 1 步
        int n = 4;
        Node nCur = head;
        for (int i = 1; i < n; i++) {
            // 向后走一步
            nCur = nCur.next;
        }
        System.out.println(nCur.val);

        boolean isFound = false;
        int target = 4;

        cur = head;
        while (cur != null) {
            if (cur.val == target) {
                isFound = true;
            }
            cur = cur.next;
        }

        System.out.println(isFound);
    }
}
