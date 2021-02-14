package day10;

import java.util.Arrays;

//https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        int indexHead = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                indexHead = i;
                break;
            }
        }
        if (indexHead == -1) {
            return new int[]{-1, -1};
        }
        int indexTail = indexHead;
        for (int i = indexHead + 1; i < nums.length; i++) {
            if (nums[i] == target) {
                indexTail = i;
            }
        }
        return new int[]{indexHead, indexTail};
    }

    public static void main(String[] args) {
        int[] nums = {2,2};
        System.out.println(Arrays.toString(searchRange(nums, 2)));
    }
}
