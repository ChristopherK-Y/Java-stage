package day09;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode-cn.com/problems/two-sum/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashTable = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashTable.containsKey(target - nums[i])) {//这里的key是数值，而value是下标
                // （方便使用get函数，因为我们需要找到index）
                return new int[]{hashTable.get(target - nums[i]), i};
            }
            hashTable.put(nums[i],i);
        }
        return new int[0];
    }
}
