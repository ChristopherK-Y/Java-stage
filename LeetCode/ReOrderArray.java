package NowCoder;

import java.util.ArrayList;
import java.util.Arrays;

//https://www.nowcoder.com/practice/ef1f53ef31ca408cada5093c8780f44b?tpId=13&tqId=11166&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
public class ReOrderArray {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param array int整型一维数组
     * @return int整型一维数组
     */
    public int[] reOrderArray(int[] array) {
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        for (int integer : array) {
            if ((integer & 1) == 0) {
                even.add(integer);
            } else {
                odd.add(integer);
            }
        }
        int insert = 0;
        odd.addAll(even);
        for (Integer integer : odd) {
            array[insert++] = integer;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(new ReOrderArray().reOrderArray(array)));
    }
}
