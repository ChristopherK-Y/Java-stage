package NowCoder;

import java.util.Arrays; 

//https://www.nowcoder.com/practice/94a4d381a68b47b7a8bed86f2975db46?tpId=13&tqId=11204&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
public class Multiply {
    public int[] multiply(int[] A) {
        int length = A.length;
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            int product = 1;
            for (int j = 0; j < length; j++) {
//                if(j == i){
//                    continue;
//                }
                if (j != i) {
                    product *= A[j];
                }
            }
            ans[i] = product;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(new Multiply().multiply(array)));
    }
}
