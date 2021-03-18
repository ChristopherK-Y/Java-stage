package my_linked_list;

public class Node {
    // 我们使用  String 作为元素类型
    public String val;
    // 前驱
    public Node prev;
    // 后继
    public Node next;

    public Node(String val) {
        this.val = val;
    }
}
