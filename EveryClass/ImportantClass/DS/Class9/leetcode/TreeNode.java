package leetcode;

public class TreeNode {
    public int val;
    public TreeNode left;   // 指向该结点的左孩子
                            // left == null 没有左孩子
                            // 进一步，被视为，以左孩子为根的一棵树
                            // 左子树（Left Sub Tree)
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return String.format("TreeNode{%c}", val);
    }
}
