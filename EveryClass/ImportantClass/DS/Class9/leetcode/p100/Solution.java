package leetcode.p100;

import leetcode.TreeNode;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
//        // 根的值不同
//        if (p.val != q.val) {
//            return false;
//        }
//
//        // 两棵树的左子树不相同
//        if (!isSameTree(p.left, q.left)) {
//            return false;
//        }
//
//        // 两棵树的右子树不相同
//        if (!isSameTree(p.right, q.right)) {
//            return false;
//        }
//
//        return true;
    }
}
