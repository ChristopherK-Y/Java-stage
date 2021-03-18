package my_linked_list;

public class MyLinkedList {
    public Node head;
    public Node last;
    public int size;

    // 一开始的链表是一个空链表
    public MyLinkedList() {
        head = null;
        last = null;
        size = 0;
    }

    // O(1)
    // 尾插
    public boolean add(String e) {
        Node node = new Node(e);

        if (head == null) {
            head = last = node;
        } else {
            node.prev = last;
            last.next = node;
            last = node;        // last = last.next;
        }

        size++;

//        if (head == null) {
//            head = node;
//        } else {
//            Node last = head;
//            while (last.next != null) {
//                last = last.next;
//            }
//            last.next = node;
//        }

        return true;
    }

    // O(n)
    public void add(int index, String e) {
        if (index < 0 || index > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (size() == 0) {
            Node node = new Node(e);
            head = last = node;
        } else if (index == 0) {
            Node node = new Node(e);
            node.next = head;
            head.prev = node;
            head = node;
        } else if (index == size()) {
            add(e);
            size--;
        } else {
            Node node = new Node(e);
            Node prev = head;
            // 从头节点向后跳 index - 1 步，找到待插入位置的前驱结点
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            Node next = prev.next;

            prev.next = node;
            next.prev = node;
            node.prev = prev;
            node.next = next;
        }

        size++;
    }

    // O(n)
    public String remove(int index) {
        if (index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        String e;
        if (size() == 1) {
            e = last.val;
            head = last = null;
        } else if (index == 0) {
            e = head.val;
            head = head.next;
            head.prev = null;
        } else if (index == size() - 1) {
            e = last.val;
            last = last.prev;
            last.next = null;
        } else {
            Node toDelete = head;
            for (int i = 0; i < index; i++) {
                toDelete = toDelete.next;
            }
            e = toDelete.val;
            Node prev = toDelete.prev;
            Node next = toDelete.next;

            prev.next = next;
            next.prev = prev;
        }

        size--;
        return e;
    }
    // O(n)
    public boolean contains(String e) {
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.val.equals(e)) {
                return true;
            }
        }

        return false;
    }
    // O(n)
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

    // O(n)
    public int lastIndexOf(String e) {
        int i = size() - 1;
        for (Node cur = last; cur != null; cur = cur.prev) {
            if (cur.val.equals(e)) {
                return i;
            }
            i--;
        }

        return -1;
    }



    // O(n)
    @Override
    public String toString() {
        // String 对象是不可变对象
        // 使用 StringBuilder 进行连接
        StringBuilder s = new StringBuilder("[");

        Node cur = head;
        while (cur != null) {
            // 创建了一个新的 String 对象
            // 扔掉了老的 String 对象
            s.append(cur.val);
            if (cur != last) {
                s.append(",");
            }
            cur = cur.next;
        }

        s.append("]");

        return s.toString();
    }

    public int size() {
        return size;
//        int count = 0;
//        Node cur = head;
//        while (cur != null) {
//            cur = cur.next;
//            count++;
//        }
//        return count;
    }
}
