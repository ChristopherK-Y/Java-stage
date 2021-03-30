package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();

        if(root == null){
            return list;
        }

        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode pop = stack.pop();
            list.add(pop.val);
            cur = pop.right;
        }
        return list;
    }
}
