package NowCoder;

import java.util.ArrayList;

//https://www.nowcoder.com/practice/c451a3fd84b64cb19485dad758a55ebe?tpId=13&tqId=11194&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
public class FindContinuousSequence {
    /**
     * 采用双指针
     * @param sum 序列需要的和
     * @return 返回可以相加为sum的连续的序列集合
     */
    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        //首先把两个指针放在最小的两个数字上面，头尾指针确定了一个数字的区间
        int head = 1;
        int tail = 2;
        //当头指针没有追上又指针的时候，说明循环可以继续
        while (head < tail) {
            //这个序列是一个等差数列（连续的数字），公式如下
            //partialSum <==> 区间的和，左闭右闭
            int partialSum = (head + tail) * (tail - head + 1) / 2;
            if (partialSum == sum) {
                //如果区间和等于目标了，那么写入当前数列，并且，头指针后移
                ArrayList<Integer> addInto = new ArrayList<>();
                for (int i = head; i <= tail; i++) {
                    addInto.add(i);
                }
                ans.add(addInto);
                head++;
            } else if (partialSum > sum) {
                //如果区间的和大于目标了，那么，头指针后移（区间中减了一个数）
                head++;
            }else{
                //如果区间的和小于目标了，那么，尾指针后移（区间中加了一个数）
                tail++;
            }
            //头尾指针相遇，说明无论头指针后移多少次，当前的区间和都是大于目标值的，所以，可以退出循环了
        }
        //当前的结果
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new FindContinuousSequence().findContinuousSequence(9));
    }
}
