package LeetCode;

import java.util.Arrays;
//https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/comments/
public class MinIncrementForUnique {
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);//先排序
        int count = 0;//记录需要加的次数
        for (int i = 1; i < A.length; i++) {
            //如果当前的数字，比前一个数小或者等于前一个数，那么就将其变为前一个数+1
            if (A[i] <= A[i - 1]) {
                int temp = A[i];
                A[i] = A[i - 1] + 1;
                count += A[i] - temp;
            }
        }
        return count;
    }
}
