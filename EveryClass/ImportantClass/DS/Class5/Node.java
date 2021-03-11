public class Node {
    public int val; // 元素
    public Node next;   // 指向下一个结点对象
                        // next == null，代表链表的最后一个结点

    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}
