package NowCoder;

import java.util.Arrays;

//https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163?tpId=13&tqId=11181&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
public class MoreThanHalfNum_Solution {
    public int moreThanHalfNum_Solution(int[] array) {
        Arrays.sort(array);
        int count = 0;
        int nowElement = array[0];
        for (int oneElement : array) {
            if (oneElement == nowElement) {
                count++;
            } else {
                count = 1;
                nowElement = oneElement;
            }
            if (count > array.length / 2) {
                return nowElement;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(new MoreThanHalfNum_Solution().moreThanHalfNum_Solution(array));
    }
}
