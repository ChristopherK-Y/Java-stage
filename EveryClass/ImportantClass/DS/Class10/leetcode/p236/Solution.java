package leetcode.p236;

import leetcode.TreeNode;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == root || q == root) {
            return root;
        }

        boolean pInLeft = containsNode(root.left, p);
        boolean qInLeft = containsNode(root.left, q);

        if (pInLeft && !qInLeft) {
            return root;
        }

        if (!pInLeft && qInLeft) {
            return root;
        }

        if (pInLeft) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }

    private boolean containsNode(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }

        if (root == p) {
            return true;
        }

        if (containsNode(root.left, p)) {
            return true;
        }

        return containsNode(root.right, p);
    }
}
