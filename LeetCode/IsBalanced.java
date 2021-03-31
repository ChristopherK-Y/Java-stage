package LeetCode;

//https://leetcode-cn.com/problems/balanced-binary-tree/
public class IsBalanced {
    public int getHeight(TreeNode root) {//标准求二叉树的高度(递归)
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {//如果根为空,那么一定是平衡的
            return true;
        }
        if (!isBalanced(root.left)) {//左子树不是平衡的话,整棵树也不是平衡的
            return false;
        }
        if (!isBalanced(root.right)) {//右子树不是平衡的话,整棵树也不是平衡的
            return false;
        }
        //左右子树都是平衡的,那么现在就看,左右子树的高度差是否在1以内
        int heightDiff = Math.abs(getHeight(root.right) - getHeight(root.left));
        return heightDiff <= 1;//如果高度差在1以内,说明就是平衡的
    }
}
