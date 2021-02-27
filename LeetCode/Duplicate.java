package NowCoder;

import java.util.*;
//https://www.nowcoder.com/practice/6fe361ede7e54db1b84adc81d09d8524?tpId=13&tqId=11203&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
public class Duplicate {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param numbers int整型一维数组
     * @return int整型
     */
    public int duplicate (int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for(int oneElement : numbers){
            if(!set.add(oneElement)){
                return oneElement;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {2,3,1,0,2,5,3};
        System.out.println(new Duplicate().duplicate(array));
    }
}
