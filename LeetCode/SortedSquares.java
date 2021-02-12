package day06;

//https://leetcode-cn.com/problems/squares-of-a-sorted-array/
public class SortedSquares {
    /**
     * 双指针，一个在数组的头，一个在数组的尾，选出绝对值较大的，然后插入末尾
     */
    public int[] sortedSquares(int[] nums) {
        int[] ret = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        int insert = nums.length - 1;
        while (start <= end) {
            if (Math.abs(nums[start]) <= Math.abs(nums[end])) {
                ret[insert--] = nums[end] * nums[end];
                end--;
            } else {
                ret[insert--] = nums[start] * nums[start];
                start++;
            }
        }
        return ret;
    }
}
