package LeetCode;

//https://leetcode-cn.com/problems/same-tree/
public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){//两棵树同时为空,那么它就是相同的(同为空树)
            return true;
        }
        if(p == null || q == null){//一个为空,一个不为空,一定不是相同的
            return false;
        }
        if(p.val != q.val){//根节点不同,一定不相同
            return false;
        }
        //根看完了,以相同的方式去看他俩的左子树和右子树,如果两棵树的左相同且右相同,那么他俩一定是相同的(根已经相同)
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
