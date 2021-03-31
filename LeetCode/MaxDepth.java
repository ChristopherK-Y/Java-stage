package LeetCode;

//https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null){//如果是空树,那么高度自然为1
            return 0;
        }
        //递归返回左子树和右子树中最大的高度然后+根节点的高度1
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
