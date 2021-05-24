package NowCoder;


import java.util.ArrayList;
import java.util.List;

/**
 * https://www.nowcoder.com/practice/cf7e25aa97c04cc1a68c8f040e71fb84
 */
public class 序列化二叉树 {
    ArrayList<Integer> preOrder = new ArrayList<>();
    ArrayList<Integer> midOrder = new ArrayList<>();

    String Serialize(TreeNode root) {
        pre(root);
        mid(root);
        return preOrder.toString() + midOrder.toString();
    }

    TreeNode Deserialize(String str) {
        return fun(preOrder, midOrder);
    }

    private TreeNode fun(List<Integer> pre, List<Integer> mid) {
        if (pre.size() == 0) {
            return null;
        }
        int rootValue = pre.get(0);
        TreeNode root = new TreeNode(rootValue);
        int numberOfLeftNode = 0;
        for (int i = 0; i < mid.size(); i++) {
            if (mid.get(i) == rootValue) {
                numberOfLeftNode = i;
                break;
            }
        }
        List<Integer> leftPre = pre.subList(1, numberOfLeftNode + 1);
        List<Integer> leftMid = mid.subList(0, numberOfLeftNode);
        List<Integer> rightPre = pre.subList(numberOfLeftNode + 1, pre.size());
        List<Integer> rightMid = mid.subList(numberOfLeftNode + 1, mid.size());

        root.left = fun(leftPre, leftMid);
        root.right = fun(rightPre, rightMid);
        return root;
    }

    private void pre(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrder.add(root.val);
        pre(root.left);
        pre(root.right);
    }

    private void mid(TreeNode root) {
        if (root == null) {
            return;
        }
        mid(root.left);
        midOrder.add(root.val);
        mid(root.right);
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.right = new TreeNode(4);

        序列化二叉树 obj = new 序列化二叉树();
        String serialize = obj.Serialize(head);
        System.out.println(serialize);
        TreeNode deserialize = obj.Deserialize(serialize);
    }
}
