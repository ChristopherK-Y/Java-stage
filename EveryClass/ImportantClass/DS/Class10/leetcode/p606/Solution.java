package leetcode.p606;

import leetcode.TreeNode;

public class Solution {
    private StringBuilder sb;
    private void preorder(TreeNode root) {
        if (root == null) {
            sb.append("()");
            return;
        }
        sb.append("(");
        sb.append(root.val);
        if (root.left == null && root.right == null) {
        } else if (root.right == null) {
            preorder(root.left);
        } else {
            preorder(root.left);
            preorder(root.right);
        }
        sb.append(")");
    }
    public String tree2str(TreeNode t) {
        sb = new StringBuilder();
        preorder(t);
        sb.delete(0, 1);
        sb.delete(sb.length() - 1, sb.length());

        return sb.toString();
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);

        n1.left = n2; n1.right = n3;
        n2.left = n4;

        Solution s = new Solution();
        String s1 = s.tree2str(n1);
        System.out.println(s1);
    }
}
