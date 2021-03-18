package my_linked_list;

public class MyLinkedListDemo {
    private static void testList(MyLinkedList list) {
        int count1 = 0;
        Node cur1 = list.head;
        while (cur1 != null) {
            count1++;
            cur1 = cur1.next;
        }

        int count2 = 0;
        Node cur2 = list.last;
        while (cur2 != null) {
            count2++;
            cur2 = cur2.prev;
        }

        if (count1 != count2) {
            throw new RuntimeException("破对象");
        }

        if (count1 != list.size) {
            throw new RuntimeException("破对象");
        }

        if (list.head == null) {
            if (list.last != null) {
                throw new RuntimeException("破对象");
            }
        }

        if (list.head != null) {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            if (last != list.last) {
                throw new RuntimeException("破对象");
            }

            Node head = list.last;
            while (head.prev != null) {
                head = head.prev;
            }

            if (head != list.head) {
                throw new RuntimeException("破对象");
            }
        }
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        testList(list);

        list.add("A");
        testList(list);

//        list.add("A");
//        list.add("B");
//        list.add("C");
//
//        // [A, B, C]
//        System.out.println(list);
//
//        list.add(2, "Z");
//        // [A, B, Z, C]
//        System.out.println(list);
//        list.add(0, "Y");
//        // [Y, A, B, Z, C]
//        System.out.println(list);
    }
}
