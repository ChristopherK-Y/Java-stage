package NowCoder;

/**
 * https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e
 *
 * 思路:
 * ①如果该树是空树,那么直接返回空就好了
 * ②如果该节点存在右孩子,那么,要找到以他的右孩子为起点,一直向左子树方向走,可以走到的最后一个节点
 * ③如果该节点不存在右孩子,那么答案可能就是他的父亲,但是不一定.
 * 1)他是他父亲的左孩子,那么答案就是他的父亲.
 * 2)他是他父亲的右孩子,那么需要找到他父亲的父亲,重复③过程,如果最后还还没有找到 XX父亲.left == XX;那么就是不存在该节点的下一节点.
 * 例如:
 * 1.right = 2;
 * 2.right = 3;
 * 3.right = 4;
 * 中序遍历结果为:1234,现在求4的下一个节点,就是不存在该节点的下一节点.
 */
public class 二叉树的下一节点 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {// empty tree
            return null;
        }
        if (pNode.right != null) {//right != null
            TreeLinkNode cur = pNode.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        }
        while (pNode.next != null) {
            TreeLinkNode father = pNode.next;
            if (father.left == pNode)
                return father;
            pNode = pNode.next;
        }
        return null;
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
