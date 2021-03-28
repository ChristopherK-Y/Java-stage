package leetcode.p110;

import leetcode.TreeNode;

public class Solution {
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Integer.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean isLeftBalance = isBalanced(root.left);
        if (!isLeftBalance) {
            return false;
        }

        boolean isRightBalance = isBalanced(root.right);
        if (!isRightBalance) {
            return false;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        int diff = leftHeight - rightHeight;
        return diff >= -1 && diff <= 1;
    }
}
