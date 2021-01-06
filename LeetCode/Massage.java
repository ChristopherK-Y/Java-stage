//一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
// 在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，
// 替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
//注意：本题相对原题稍作改动
//
//示例 1：
//输入： [1,2,3,1]
//输出： 4
//解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
//
//示例 2：
//输入： [2,7,9,3,1]
//输出： 12
//解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
//
//示例 3：
//输入： [2,1,4,5,3,1,1,3]
//输出： 12
//解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/the-masseuse-lcci
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


public class Massage {

    /**
     * Method 2:
     * 功能：给定一个数组，找出其中的最大和（条件为，被加的数不可以相邻）
     * 返回值：所加出来的数字，一个Int 
     * 参数：给定的整形数组
     * 方法：动态规划
     *
     * 思路：(这个ans数组是从i~length-1的局部最优的解)
     * 给出方程：
     * ① ans[i] = nums[length-1];                         When: i == length - 1
     * ② ans[i] = max(nums[length - 2],nums[length - 1]); When: i == length - 2
     * ③ ans[i] = max((nums[i] + ans[i + 2]), ans[i+1]);  When: i <= length - 3
     *
     * ① 假设：给定的数组只有一个元素，那么最大的和就是唯一的这个数字
     * ② 假设：给定的数组只有2个元素，又因为所加的和元素之间是不可以相邻的，所以只可以是这俩个数中最大的一个
     * ③ 然后，就是大于2个元素的情况：
     * 1) 如果包含当前的元素，那么他的和为：当前的这个元素的值 + ans[i + 2]
     * 2) 如果不包含当前的元素，那么当前的和为：ans[i + 1]
     * 当前的最优解一定是这两种情况中值最大的那一个
     *
     */
    public static int massage(int[] nums) {
        int length = nums.length;
        if (length < 1) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        int[] ans = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            if (i <= length - 3) {
                ans[i] = Math.max(nums[i] + ans[i + 2], ans[i + 1]);
            } else if (i == length - 2) {
                ans[i] = Math.max(nums[i], nums[i + 1]);
            } else {
                ans[i] = nums[i];
            }
        }
        return ans[0];
    }

    /**
     * 测试函数
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(massage(nums));
    }


    /**
     * Method 1
     * Wrong method:
     */
//    public static int massage(int[] nums) {
//        int max = 0;
//        for (int i = 0; i <= nums.length - 1; i++) {
//            int sum = 0;
//            for (int j = i; j <= nums.length - 1; j += 2) {
//                sum += nums[j];
//            }
//            if (sum > max) {
//                max = sum;
//            }
//        }
//        return max;
//    }
}
