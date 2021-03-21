package my_linked_list;

public class MyIterator {
    private Node cur;

    public MyIterator(Node head) {
        cur = head;
    }

    public boolean hasNext() {
        return cur != null;
    }

    public String next() {
        String e = cur.val;
        cur = cur.next;
        return e;
    }
}
