package NowCoder;

//https://www.nowcoder.com/practice/7a0da8fc483247ff8800059e12d7caf1?tpId=13&tqId=11200&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
public class SumSolution {
    /**
     * 思路：
     * ①两个数的按位异或是两数每位的和，但是不带进位
     * ②两个数的按位与是两个数的每一位是否产生进位
     */
    public int sum_Solution(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int temp = i;
            while (temp != 0) {
                int tempSum = sum ^ temp;
                int carry = (sum & temp) << 1;
                sum = tempSum;
                temp = carry;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new SumSolution().sum_Solution(15));
    }
}
