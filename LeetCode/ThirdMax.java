package day08;

import java.util.Arrays;

//https://leetcode-cn.com/problems/third-maximum-number/
public class ThirdMax {
    /**
     *
     * @param nums 一个整数数组
     * @return int
     */
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        int temp = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == temp) {
                continue;
            }
            temp = nums[i];
            count++;
            if (count == 3) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}
