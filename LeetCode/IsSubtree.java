package LeetCode;

//https://leetcode-cn.com/problems/subtree-of-another-tree/
public class IsSubtree {
    public boolean isSubtree(TreeNode s, TreeNode t) {//判断t是不是s的子树
        if(s == null){//递归过程中,s都遍历完了,还没有判断完,那么t一定不是s的子树
            return false;
        }
        //现在就是去判断,s和t是个相同 或 t是否在s的左子树中 或 t是否在s的右子树中
        return isSame(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
    }
    public boolean isSame(TreeNode s, TreeNode t){//判断两棵树是否相同
        if(s == null && t == null){//两棵树同时为空,那么它就是相同的(同为空树)
            return true;
        }
        if(t == null || s == null){//一个为空,一个不为空,一定不是相同的
            return false;
        }
        if(s.val != t.val){//根节点不同,一定不相同
            return false;
        }
        //根看完了,以相同的方式去看他俩的左子树和右子树,如果两棵树的左相同且右相同,那么他俩一定是相同的(根已经相同)
        return isSame(s.left,t.left) && isSame(s.right,t.right);
    }
}
