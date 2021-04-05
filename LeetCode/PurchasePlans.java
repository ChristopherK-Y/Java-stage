package LeetCode;

import java.util.*;

class PurchasePlans {
    public int purchasePlans(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        long count = 0;
        while(right < nums.length && nums[0] + nums[right] <= target){
            right++;
        }
        if(right == nums.length || nums[right] + nums[0] > target){
            right--;
        }
        while(left < right){
            count += (right - left);
            left++;
            while(left < right && nums[left] + nums[right] > target){
                right--;
            }
        }
        //if(right > left){count += (right - left);}

        return (int)(count % 1000000007);
    }
}