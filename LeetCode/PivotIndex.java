package day07;

//https://leetcode-cn.com/problems/find-pivot-index/
public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {//求数组的总和sum
            sum += num;
        }
        int nowSum = 0;//当前的元素之和。
        for (int i = 0; i < nums.length; i++) {
            if (sum - nowSum - nums[i] == nowSum) {//(前式)<==>(当前坐标,最后一个坐标]的和 == [第一个,当前坐标)的和
                return i;//如果相等，那么就恰好，则返回当前的Index i 即可
            }
            nowSum+=nums[i];
        }
        return -1;//没有返回任何的东西，那么就不存在一个对称中心，则返回-1
    }
}
