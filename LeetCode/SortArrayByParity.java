package day07;

import java.util.Arrays;

//https://leetcode-cn.com/problems/sort-array-by-parity/
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int[] ret = new int[A.length];
        int even = 0;
        int odd = ret.length - 1;

        for (int oneNumber : A) {
            if ((oneNumber & 1) == 0) {//is an even number
                ret[even++] = oneNumber;
            } else {//is an odd number
                ret[odd--] = oneNumber;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        SortArrayByParity test = new SortArrayByParity();
        int[] a = {0, 2, 1};
        System.out.println(Arrays.toString(test.sortArrayByParity(a)));
    }
}
