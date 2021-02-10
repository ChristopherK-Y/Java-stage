package day04;

import java.util.Arrays;

//https://leetcode-cn.com/problems/merge-sorted-array/
public class Merge {
    //方法1：太暴力了
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    //方法2:3指针，全部倒着走
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length == 0 || n == 0) {
            return;
        }
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
        }
        int insert = m + n - 1;
        int nums1Last = m - 1;
        int nums2Last = n - 1;
        while (true) {
            if (nums1[nums1Last] >= nums2[nums2Last]) {
                nums1[insert--] = nums1[nums1Last--];
            } else {
                nums1[insert--] = nums2[nums2Last--];
            }
            if (nums1Last == -1) {
                for (; nums2Last >= 0; nums2Last--) {
                    nums1[insert--] = nums2[nums2Last];
                }
                return;
            }
            if (nums2Last == -1) {
                for (; nums1Last >= 0; nums1Last--) {
                    nums1[insert--] = nums1[nums1Last];
                }
                return;
            }
        }
    }
}
