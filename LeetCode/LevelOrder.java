package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> heightQueue = new LinkedList<>();
        queue.add(root);
        heightQueue.add(0);//首先把根入队列
        int nowLevel = -1;//标志当前走到的层树
        while(!queue.isEmpty()){//队列为空,代表遍历结束
            int level = heightQueue.remove();//当前节点层数出队
            TreeNode remove = queue.remove();//当前节点出队
            if(level != nowLevel){//如果还没有当前层数的List那么创建一个
                list.add(new ArrayList<>());
                nowLevel = level;//并且更新当前走到的层数
            }
            list.get(level).add(remove.val);//把出队的节点添加进去
            if(remove.left != null){//如果为空,就不入队了
                queue.add(remove.left);
                heightQueue.add(level+1);
            }
            if(remove.right != null){//如果为空,就不入队了
                queue.add(remove.right);
                heightQueue.add(level+1);
            }
        }
        return list;//最后,返回list
    }
}
