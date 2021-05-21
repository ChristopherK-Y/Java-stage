package NowCoder;

import java.util.*;


public class 把二叉树打印成多行 {
    ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        LinkedList<TreeNode> nodeQueue = new LinkedList<>();
        LinkedList<Integer> heightQueue = new LinkedList<>();

        nodeQueue.add(root);
        heightQueue.add(0);
        int nowHeight = -1;

        while (!nodeQueue.isEmpty()) {
            int height = heightQueue.remove();
            if (nowHeight != height) {
                ans.add(new ArrayList<>());
                nowHeight = height;
            }
            TreeNode remove = nodeQueue.remove();
            ans.get(nowHeight).add(remove.val);

            if (remove.left != null) {
                nodeQueue.add(remove.left);
                heightQueue.add(nowHeight + 1);
            }

            if (remove.right != null) {
                nodeQueue.add(remove.right);
                heightQueue.add(nowHeight + 1);
            }
        }
        return ans;
    }
}
