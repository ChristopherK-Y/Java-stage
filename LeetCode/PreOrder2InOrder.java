package NowCoder;

import java.util.Scanner;

public class PreOrder2InOrder {
    static class TreeNode{
        char val;
        TreeNode left;
        TreeNode right;

        public TreeNode(){

        }
        public TreeNode(char val){
            this.val = val;
        }
    }
    public static int index = 0;
    public static TreeNode preOrder(char[] preorder){
        if(index >= preorder.length){//如果当前已经把字符串走完了,那么返回null
            return null;
        }
        char rootValue = preorder[index++];//取出根节点
        if(rootValue == '#'){//如果根为空,那么返回null
            return null;
        }
        //递归构建树
        TreeNode root = new TreeNode(rootValue);
        root.left = preOrder(preorder);
        root.right = preOrder(preorder);
        return root;
    }

    public static void inOrder(TreeNode root){//给定树根,返回中序遍历
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        int length = in.length();
        while(index < length){//该字符串可能为森林,index走不玩,不结束
            inOrder(preOrder(in.toCharArray()));
            System.out.println();
        }
    }
}
