package NowCoder;

import com.sun.istack.internal.NotNull;

import java.util.Arrays;

public class FindNumsAppearOnce {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param array int整型一维数组
     * @return int整型一维数组
     */
    public int[] findNumsAppearOnce(int[] array) {
        int twoNumber = 0;//twoNumber为两个单身狗的异或
        for (int oneElement : array) {
            twoNumber ^= oneElement;
        }
        //找到twoNumber中的一个1（找最后一个1，比较简单）（twoNumber中的每一个1都代表这这两个单身狗在这一位上是不一样的）
        twoNumber &= -twoNumber;
//        {
//            //方法2:
//            int bit = 1;
//            while ((bit & twoNumber) == 0) {
//                bit <<= 1;
//            }
//            twoNumber = bit;
//        }
        int a = 0, b = 0;
        for (int oneElement : array) {
            //拿着这一位不一样的，就可以在所有的数字中，把两个单身狗分成两部分。那么直接分开异或就好了。
            if ((oneElement & twoNumber) == 0) {
                a ^= oneElement;
            } else {
                b ^= oneElement;
            }
        }
        return a < b ? new int[]{a, b} : new int[]{b, a};
    }

    public static void main(String[] args) {
        int[] array = {1, 1, 2, 2, 3, 3, 4, 5};
        System.out.println(Arrays.toString(new FindNumsAppearOnce().findNumsAppearOnce(array)));
    }
}
