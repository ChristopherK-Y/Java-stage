package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

//判断是否为完全二叉树
public class CompleteTree {
    public static boolean isCompleteTree(TreeNode aRoot) {
        if (aRoot == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(aRoot);
        while (true) {
            TreeNode remove = queue.remove();
            if (remove == null) {
                break;
            }
            queue.add(remove.left);
            queue.add(remove.right);
        }
        for (TreeNode oneElement : queue) {
            if (oneElement != null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(8);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        e.left = h;
        System.out.println(isCompleteTree(a));
    }
}
