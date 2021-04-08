package JZOffer36;

public class Solution {
    private Node head;
    private Node last;

    public Node treeToDoublyList(Node root) {
        head = null;
        last = null;

        inorder(root);

        head.left = last;
        last.right = head;

        return head;
    }

    private void inorder(Node node) {
        if (node != null) {
            inorder(node.left);

            // 进行尾插
            if (last != null) {
                last.right = node;
            } else {
                head = node;
            }
            node.left = last;
            last = node;

            inorder(node.right);
        }
    }
}
