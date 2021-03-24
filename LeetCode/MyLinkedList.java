package LeetCode;

//https://leetcode-cn.com/problems/design-linked-list/submissions/
class Node{
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
        next = null;
    }
}

public class MyLinkedList {
    private int size;
    private Node head;
    private Node tail;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        //null
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        Node cur = head;
        for (int i = 0; i < index; i++) {
            if (cur != null) {
                cur = cur.next;
            }
        }
        if(cur != null){
            return cur.val;
        }
        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }

        if (index <= 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            Node cur = head;
            for (int i = 1; i < index; i++) {
                if (cur != null) {
                    cur = cur.next;
                }
            }
            Node prev = cur;
            Node next = cur.next;
            Node newNode = new Node(val);
            prev.next = newNode;
            newNode.next = next;
            size++;
        }

    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index >= 0 && index < size) {
            if (index == 0) {
                head = head.next;
                size--;
            } else if (index == size - 1) {
                Node cur = head;
                while (cur.next.next != null) {
                    cur = cur.next;
                }
                cur.next = null;
                tail = cur;
                size--;
            } else {
                Node cur = head;
                for (int i = 1; i < index; i++) {
                    if (cur != null) {
                        cur = cur.next;
                    }
                }
                Node prev = cur;
                prev.next = prev.next.next;
                size--;
            }
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
