package NowCoder;

import java.util.*;

/**
 * https://www.nowcoder.com/practice/ef068f602dde4d28aab2b210e859150a
 */
public class 二叉搜索树的第k个节点 {
    public ArrayList<TreeNode> list = new ArrayList<>();

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (k == 0) {
            return null;
        }
        fun(pRoot);
        return (list.size() < k) ? null : list.get(k - 1);
    }

    public void fun(TreeNode pRoot) {
        if (pRoot == null) {
            return;
        }
        fun(pRoot.left);
        list.add(pRoot);
        fun(pRoot.right);
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
