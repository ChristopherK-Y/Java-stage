package day13;

import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/subsets/
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        int length = nums.length;
        List<List<Integer>> ret = new ArrayList<>(length);
        //有多少个数那么这个长度就是多少//返回变量
        for (int i = 0; i < 1 << length; i++) {
            List<Integer> temp = new ArrayList<>(length);
            //当前的i（十进制数字）所对应的那个List
            for (int j = 0; j < length; j++) {
                if (((i >> j) & 1) == 1) {
                    //一个bit一个bit的对比，循环右移判断最后的一位，如果匹配，那么就加入
                    temp.add(nums[j]);
                }
            }
            //把当前的List加入ret
            ret.add(temp);
        }
        return ret;
    }
}
