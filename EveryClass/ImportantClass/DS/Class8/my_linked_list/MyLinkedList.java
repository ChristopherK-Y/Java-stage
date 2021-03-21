package my_linked_list;

public class MyLinkedList {
    private Node head;
    private Node last;
    private int size;

    public boolean add(String e) {
        Node node = new Node(e);
        if (size == 0) {
            head = last = node;
        } else {
            last.next = node;
            node.prev = last;
            last = node;
        }
        size++;
        return true;
    }

    public void add(int index, String e) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        Node node = new Node(e);
        if (size == 0) {
            head = last = node;
        } else if (index == 0) {
            node.next = head;
            head.prev = node;
            head = node;
        } else if (index == size) {
            node.prev = last;
            last.next = node;
            last = node;
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            Node next = prev.next;

            node.prev = prev;
            node.next = next;
            prev.next = node;
            next.prev = node;
        }

        size++;
    }

    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        String e;
        if (size == 1) {
            e = head.val;
            head = last = null;
        } else if (index == 0) {
            e = head.val;
            head = head.next;
            head.prev = null;
        } else if (index == size - 1) {
            e = last.val;
            last = last.prev;
            last.next = null;
        } else {
            Node toDel = head;
            for (int i = 0; i < index; i++) {
                toDel = toDel.next;
            }
            e = toDel.val;
            Node prev = toDel.prev;
            Node next = toDel.next;
            prev.next = next;
            next.prev = prev;
        }

        size--;
        return e;
    }

    public int indexOf(String e) {
        int i = 0;
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.val.equals(e)) {
                return i;
            }
            i++;
        }

        return -1;
    }

    public int lastIndexOf(String e) {
        int i = size - 1;
        for (Node cur = last; cur != null; cur = cur.prev) {
            if (cur.val.equals(e)) {
                return i;
            }
        }

        return -1;
    }

    public boolean contains(String e) {
        return indexOf(e) >= 0;
    }

    // O(n)
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.val;
    }

    // O(n)
    public String set(int index, String e) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        String oldE = cur.val;
        cur.val = e;
        return oldE;
    }

    public boolean remove(String e) {
        int index = indexOf(e);
        if (index >= 0) {
            remove(index);
            return true;
        }

        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = null;
        last = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (Node cur = head; cur != null; cur = cur.next) {
            sb.append(cur.val);
            if (cur != last) {
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }

    public MyIterator iterator() {
        return new MyIterator(head);
    }
}
