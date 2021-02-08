package day02;

//https://leetcode-cn.com/problems/search-insert-position/
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target || target < nums[i]) {//如果等于，就直接返回下标，因为是有序的数组，那么如果小于，就直接插入即可，所以直接放回i
                return i;
            }
        }
        return nums.length;//比所有的都大，就直接插在最后
    }
}
