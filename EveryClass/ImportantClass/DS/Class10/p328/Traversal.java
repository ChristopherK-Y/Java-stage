package p328;

import java.util.*;

public class Traversal {
    public static void preorder(TreeNode root) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                System.out.println(cur.val);
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode pop = stack.pop();

            cur = pop.right;
        }
    }

    public static void inorder(TreeNode root) {
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode pop = stack.pop();
            System.out.println(pop.val);

            cur = pop.right;
        }
    }



    public static void postorder(TreeNode root) {
        TreeNode cur = root;
        TreeNode last = null;   // 记录上次刚刚后序遍历过的结点
        Stack<TreeNode> stack = new Stack<>();
        //int height = -1;
        List<TreeNode> pathOf8 = null;
        List<TreeNode> pathOf4 = null;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                // 第一次经过结点
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode pop = stack.peek();
            //height = Integer.max(height, stack.size());

            if (pop.right == null) {

                if (pop.val == 4) {
                    pathOf4 = new ArrayList<>(stack);
                } else if (pop.val == 8) {
                    pathOf8 = new ArrayList<>(stack);
                }

                // 第二次经过结点，但同时看作第三次经过结点
                stack.pop();
                //System.out.println(pop.val);
                last = pop;
            } else if (pop.right == last) {

                if (pop.val == 4) {
                    pathOf4 = new ArrayList<>(stack);
                } else if (pop.val == 8) {
                    pathOf8 = new ArrayList<>(stack);
                }

                // 第三次经过结点
                stack.pop();
                //System.out.println(pop.val);
                last = pop;
            } else {
                // 第二次经过结点
                cur = pop.right;
            }
        }

        //System.out.println(height);
        System.out.println(pathOf4);
        System.out.println(pathOf8);
    }

    public static void levelorder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();
        queue.add(root);
        levelQueue.add(0);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            int level = levelQueue.remove();
            System.out.println(level + ": " + node.val);

            if (node.left != null) {
                queue.add(node.left);
                levelQueue.add(level + 1);
            }

            if (node.right != null) {
                queue.add(node.right);
                levelQueue.add(level + 1);
            }
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();
        queue.add(root);
        levelQueue.add(0);

        int lastLevel = -1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            int level = levelQueue.remove();
            if (lastLevel != level) {
                list.add(new ArrayList<>());
            }
            lastLevel = level;
            //System.out.println(level + ": " + node.val);
            List<Integer> rowList = list.get(level);
            rowList.add(node.val);

            if (node.left != null) {
                queue.add(node.left);
                levelQueue.add(level + 1);
            }

            if (node.right != null) {
                queue.add(node.right);
                levelQueue.add(level + 1);
            }
        }

        return list;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);

        int leftSize = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                leftSize = i;
            }
        }

        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1 + leftSize);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, leftSize);
        root.left = buildTree(leftPreorder, leftInorder);

        int[] rightPreorder = Arrays.copyOfRange(preorder, 1 + leftSize, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, leftSize + 1, inorder.length);
        root.right = buildTree(rightPreorder, rightInorder);

        return root;
    }

    public static boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (true) {
            TreeNode node = queue.remove();
            if (node == null) {
                break;
            }
            queue.add(node.left);
            queue.add(node.right);
        }

        // 检查队列中剩余的元素，有没有 != null 的情况
        for (TreeNode node : queue) {
            if (node != null) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 5, 8, 3, 6, 7};
        int[] inorder = {4, 2, 5, 8, 1, 6, 3, 7};
        TreeNode root = buildTree(preorder, inorder);

        List<List<Integer>> lists = levelOrder(root);
        System.out.println(lists);
    }
}
