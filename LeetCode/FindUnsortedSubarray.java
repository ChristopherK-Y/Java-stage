package day12;

//https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
public class FindUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int head = 0;
        int tail = 0;
        int min = Integer.MAX_VALUE;//将最小值，设为int的最大值，那么就一定可以找到这个值
        int max = Integer.MIN_VALUE;//将最大值，设为int的最小值，那么就一定可以找到这个值
        for (int i = 0; i < nums.length - 1; i++) {//一个for里面找到无序里面的最大值和最小值
            if (nums[i] > nums[i + 1]) {
                min = Math.min(nums[i + 1], min);
                max = Math.max(nums[i], max);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            //从头开始，一直往后，找到第一个大于最小值的，那么这个index就是下界
            if (nums[i] > min) {
                head = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            //从尾开始，一直往前，找到第一个小于最大值的，那么这个index就是上界
            if (nums[i] < max) {
                tail = i;
                break;
            }
        }
        if (head == 0 && tail == 0) {//如果上下界都没有修改，那么就是有序的，不存在无序片段
            return 0;
        }
        return tail - head + 1;//返回他们的长度
    }

    public static void main(String[] args) {
        FindUnsortedSubarray findUnsortedSubarray = new FindUnsortedSubarray();
        int[] nums = {1, 3, 2, 2, 2};
        System.out.println(findUnsortedSubarray.findUnsortedSubarray(nums));
    }
}
