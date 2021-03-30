package LeetCode;

import java.util.Arrays;

//https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class BuildTreeWithPreAndIn {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);
        int leftSize = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                leftSize = i;
            }
        }

        int[] leftPre = Arrays.copyOfRange(preorder, 1, leftSize + 1);
        int[] leftIn = Arrays.copyOfRange(inorder, 0, leftSize);
        int[] rightPre = Arrays.copyOfRange(preorder, leftSize + 1, preorder.length);
        int[] rightIn = Arrays.copyOfRange(inorder, leftSize + 1, inorder.length);
        root.left = buildTree(leftPre, leftIn);
        root.right = buildTree(rightPre, rightIn);
        return root;
    }
}
