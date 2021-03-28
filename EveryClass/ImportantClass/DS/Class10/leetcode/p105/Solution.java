package leetcode.p105;

import leetcode.TreeNode;

import java.util.Arrays;

public class Solution {
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

        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1 + leftSize);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, leftSize);
        root.left = buildTree(leftPreorder, leftInorder);

        int[] rightPreorder = Arrays.copyOfRange(preorder, 1 + leftSize, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, leftSize + 1, inorder.length);
        root.right = buildTree(rightPreorder, rightInorder);

        return root;
    }
}
