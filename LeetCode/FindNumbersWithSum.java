package NowCoder;

import java.util.ArrayList;

//https://www.nowcoder.com/practice/390da4f7a00f44bea7c2f3d19491311b?tpId=13&tqId=11195&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
public class FindNumbersWithSum {
    //方法1：暴力复杂法：
    public ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
        int end = array.length - 1;
        ArrayList<Integer> ans = new ArrayList<>();
        while (array[end] > sum && end > 0) {
            end--;
        }
        for (int i = 0; i <= end; i++) {
            for (int j = end; j > i; j--) {
                int number1 = array[i];
                int number2 = array[j];
                if (number1 + number2 == sum) {
                    ans.add(number1);
                    ans.add(number2);
                    return ans;
                }
            }
        }
        return ans;
    }

    //方法2：单层n
    public ArrayList<Integer> findNumbersWithSum2(int[] array, int sum) {
        int start = 0;
        int end = array.length - 1;
        ArrayList<Integer> ans = new ArrayList<>();
        while (start < end) {
            int tempSum = array[start] + array[end];
            if(tempSum > sum){
                //如果当前的和大于sum，那么一定是end--，因为，现在是最小的和最大的相加，只能让最大的变小，才可能让和等于sum
                end--;
            }else if(tempSum < sum){
                //如果当前的和小于sum，那么一定是start++，因为，现在是最小的和最大的相加，只能让最小的变大，才可能让和等于sum
                start++;
            }else{
                //相等的时候，只要添加进ArrayList,返回就好了
                ans.add(array[start]);
                ans.add(array[end]);
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 4, 7, 11, 15};
        System.out.println(new FindNumbersWithSum().findNumbersWithSum(array, 15));
    }
}
