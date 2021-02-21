//https://leetcode-cn.com/problems/running-sum-of-1d-array/
public class RunningSum {
    public int[] runningSum(int[] nums) {
        if (nums.length < 2) {//如果数组的长度小于1或者甚至为0，那么直接返回就好了
            return nums;
        }
        for (int i = 1; i < nums.length; i++) {
            //从第二个元素开始访问，当前的元素和就是当前的元素和他之前的那个元素的和
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
