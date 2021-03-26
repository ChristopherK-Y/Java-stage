public class TreeTraversal {
    // 前序遍历 preorder traversal
    // 参数中是树，不是结点
    public static void preorder(TreeNode root) {
        if (root == null) {
            // 根结点不存在，说明是空树
            return;
        }

        // 遍历到任意一个结点时，只需要打印根的 val
        System.out.printf("%c ", root.val);

        preorder(root.left);    // root.left 代表是一整棵左子树
        preorder(root.right);
    }
    // 中序遍历 inorder traversal
    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.printf("%c ", root.val);
        inorder(root.right);
    }
    // 后序遍历 postorder traversal
    public static void postorder(TreeNode root) {
        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.printf("%c ", root.val);
    }

    public static void allAdd1(TreeNode root) {
        if (root != null) {
            root.val += 1;
            allAdd1(root.left);
            allAdd1(root.right);
        }
    }

    public static int count;
    public static void count1(TreeNode root) {
        if (root != null) {
            count++;
            count1(root.left);
            count1(root.right);
        }
    }

    public static int count2(TreeNode root) {
        if (root != null) {
            int leftCount = count2(root.left);
            int rightCount = count2(root.right);

            return 1 + leftCount + rightCount;
        }

        return 0;
    }

    private static int leafCount;
    private static void countLeaf1(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            leafCount++;
        }
        countLeaf1(root.left);
        countLeaf1(root.right);
    }

    private static int countLeaf2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int left = countLeaf2(root.left);
        int right = countLeaf2(root.right);

        return left + right;
    }

    public static int getKthSize(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        if (k == 1) {
            return 1;
        }

        int left = getKthSize(root.left, k - 1);
        int right = getKthSize(root.right, k - 1);

        return left + right;
    }

    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        //int m = left > right ? left : right;
        //int m = Integer.max(left, right);
        int m = Math.max(left, right);

        return m + 1;
    }

    public static boolean contains0(TreeNode root, int e) {
        if (root == null) {
            return false;
        } else if (root.val == e) {
            return true;
        } else if (contains(root.left, e)) {
            return true;
        } else if (contains(root.right, e)) {
            return true;
        }
        return false;
    }

    public static boolean contains(TreeNode root, int e) {
        if (root == null) {
            return false;
        }

        if (root.val == e) {
            return true;
        }

        if (contains(root.left, e)) {
            return true;
        }

        return contains(root.right, e);
    }

    // 返回 null，代表 e 不在树中
    // 否则，返回 e 所在的结点
    public static TreeNode nodeOf(TreeNode root, int e) {
        if (root == null) {
            return null;
        }
        if (root.val == e) {
            return root;    // 因为 root 就是 e 所在的结点
        }

        TreeNode r = nodeOf(root.left, e);
        if (r != null) {
            return r;
        }

        return nodeOf(root.right, e);
    }

    public static void main(String[] args) {
        TreeNode root = BuildTree.buildTree1();
        TreeNode r = nodeOf(root, 'f');
        System.out.println(r);

//        System.out.println(getHeight(root));
//        for (int k = 1; k < 6; k++) {
//            System.out.println(getKthSize(root, k));
//        }

//        System.out.println(countLeaf2(root));
//        leafCount = 0;
//        countLeaf1(root);
//        System.out.println(leafCount);
//        leafCount = 0;
//        countLeaf1(root);
//        System.out.println(leafCount);
//        count = 0;
//        count1(root);
//        System.out.println(count);
//        count = 0;
//        count1(root);
//        System.out.println(count);
//
//        System.out.println(count2(root));
//        System.out.println(count2(root));
//        System.out.println(count2(root));
//        allAdd1(root);
//
//        System.out.print("前序遍历:");
//        preorder(root);
//        System.out.println();
//
//
//        System.out.print("中序遍历:");
//        inorder(root);
//        System.out.println();
//
//
//        System.out.print("后序遍历:");
//        postorder(root);
//        System.out.println();
    }
}
