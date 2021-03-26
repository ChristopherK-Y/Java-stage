package leetcode.p144;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    private List<Integer> list = new ArrayList<>();

    private void preorder(TreeNode root) {
        if (root == null) {
            return;
        }

        //System.out.println(root);
        list.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        list.clear();
        preorder(root);
        return list;
    }
}
