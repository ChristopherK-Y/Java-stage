package LeetCode;

import java.util.*;

//https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode last = null;

        if(root == null){
            return list;
        }

        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode peek = stack.peek();
            if(peek.right == null){
                list.add(peek.val);
                last = stack.pop();
            }else if(peek.right == last){
                list.add(peek.val);
                last = stack.pop();
            }else{
                cur = peek.right;
            }
        }
        return list;

    }
}
