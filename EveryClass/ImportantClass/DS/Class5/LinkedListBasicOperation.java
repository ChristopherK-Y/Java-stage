public class LinkedListBasicOperation {
    public static Node pushFront(Node head, int val) {
        // 1. 把元素 val 装入结点中
        Node node = new Node(val);
        node.next = head;
        return node;
    }

    public static Node popFront(Node head) {
        // head != null

        return head.next;
    }

    private static void printLinkedList(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    private static Node pushBack(Node head, int val) {
        Node node = new Node(val);
        if (head != null) {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = node;

            return head;
        } else {
            return node;
        }
    }

    private static Node popBack(Node head) {
        // head != null
        if (head.next == null) {
            return null;
        } else {
            Node last = head;
            while (last.next.next != null) {
                last = last.next;
            }
            // last 是最后一个结点
            last.next = null;

            return head;
        }
    }

    public static void main(String[] args) {
        Node head = null;

        head = pushBack(head, 1);
        head = pushBack(head, 2);
        head = pushBack(head, 3);

        head = popBack(head);
        printLinkedList(head);
        head = popBack(head);
        printLinkedList(head);
        head = popBack(head);
        printLinkedList(head);
    }
}
