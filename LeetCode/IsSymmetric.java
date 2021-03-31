package LeetCode;

//https://leetcode-cn.com/problems/symmetric-tree/
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {//如果根节点为空,那么就是对称的二叉树
            return true;
        }
        return myFun(root.left, root.right);//否则看左子树和右子树是否对称
    }

    private boolean myFun(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            //如果没有左子树和右子树,那么就是对称的
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            //如果左右子树只有一方为空树或他们的根节点不一样,那么一定不是对称的
            return false;
        }
        //走到这一步,说明,左右子树都不为空且根相同,那么现在去看左子树的左边和右子树的右边 和左子树的右边和右子树的左边是否对称.
        return myFun(left.left, right.right) && myFun(left.right, right.left);
    }
}
