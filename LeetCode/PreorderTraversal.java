package LeetCode;

import java.util.*;

//https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) {
            return list;
        }

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {//一直向左走
                stack.push(cur);
                list.add(cur.val);
                cur = cur.left;
            }

            TreeNode pop = stack.pop();//走不动的时候，出栈向右走
            cur = pop.right;
        }
        return list;
    }
}
