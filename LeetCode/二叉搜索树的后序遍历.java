package NowCoder;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。
 * （ps：我们约定空树不是二叉搜素树）
 * https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd
 */
public class 二叉搜索树的后序遍历 {
    /**
     * 思路：
     * 递归->>
     * 首先可以把一个数组分为3部分，其中①左子树②右子树③根节点
     * 找到左子树和右子树的边界就好了，根就是最后一个元素
     * 这里采用的是倒着往回找，所以，只需要判断，从边界往前的所有元素（左子树）是否都小于当前的元素
     * ①如果大于或者等于，直接返回false
     * ②如果都小于，那么递归判断左子树和右子树是否为二叉搜索树
     */
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return fun(sequence, 0, sequence.length - 1);
    }

    private boolean fun(int[] sequence, int start, int end) {
        if (end - start <= 0) {
            return true;
        }
        int middle = sequence[end];
        int div = end - 1;
        while (div >= start) {
            if (sequence[div] < middle) {
                break;
            }
            div--;//find the div at "dic"
        }
        for (int i = start; i <= div; i++) {
            if (sequence[i] > middle) {
                return false;
            }
        }
        return fun(sequence, start, div) && fun(sequence, div + 1, end - 1);
    }

    public static void main(String[] args) {
        int[] s = {5, 4, 3, 2, 1};
        System.out.println(new 二叉搜索树的后序遍历().VerifySquenceOfBST(s));
    }
}
