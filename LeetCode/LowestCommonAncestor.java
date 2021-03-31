package LeetCode;

//https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
public class LowestCommonAncestor {
    public static boolean contains(TreeNode root,TreeNode target){//判断target在不在这棵树上
        if(root == null){
            return false;
        }
        if(root.val == target.val){
            return true;
        }
        return contains(root.left,target) || contains(root.right,target);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){//如果树为空，那么没有公共祖先
            return null;
        }
        if(root.val == p.val || root.val == q.val){//如果其中一个节点就是根节点，那儿么公共祖先就是本身
            return root;
        }

        boolean leftp = contains(root.left,p);//p在不在左子树中
        boolean leftq = contains(root.left,q);//q在不在左子树中

        if(leftp && !leftq || !leftp && leftq){//如果一个在左子树一个在右子树,那么根节点就是root
            return root;
            //接下来就说明,他俩在同一颗树
        }else if(leftp){//如果都在左数,那么递归判断左树
            return lowestCommonAncestor(root.left,p,q);
        }else{//否则就都在右树,那么递归判断右树
            return lowestCommonAncestor(root.right,p,q);
        }
    }
}
