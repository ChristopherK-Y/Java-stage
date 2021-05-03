//https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5?
/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
/**
* 中序遍历，直接进行尾插操作！
*/
public class Solution {
    public TreeNode head = null;
    public TreeNode last;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        Convert(pRootOfTree.left);
        if(head == null){
            head = pRootOfTree;
            last = head;
        }else{
            last.right = pRootOfTree;
            pRootOfTree.left = last;
            last = last.right;
        }
        Convert(pRootOfTree.right);
        return head;
    }
}