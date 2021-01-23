package 方法的使用_作业;

import java.util.Arrays;

//5.调整数组顺序使得奇数位于偶数之前。调整之后，不关心大小顺序。
public class ParitySwap {
    //method1:violence
    public static long[] paritySwap1(long[] array) {
        long[] ans = new long[array.length];
        int frontIndex = 0;
        int behindIndex = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                ans[frontIndex++] = array[i];
            } else {
                ans[behindIndex--] = array[i];
            }
        }
        return ans;
    }

    //method2:two pointer
    public static void paritySwap2(long[] array) {
        int frontIndex = 0;
        int behindIndex = array.length - 1;
        while (frontIndex < behindIndex) {
            while (frontIndex < behindIndex && array[frontIndex] % 2 != 0) {//从前往后找到一个偶数
                frontIndex++;
            }
            while (frontIndex < behindIndex && array[behindIndex] % 2 == 0) {//从后往前找到一个奇数
                behindIndex--;
            }
            array[frontIndex] ^= array[behindIndex];//Swap Two Numbers
            array[behindIndex] ^= array[frontIndex];
            array[frontIndex] ^= array[behindIndex];

            frontIndex++;//After swap update index
            behindIndex--;
        }
    }

    public static void main(String[] args) {
        long[] array = new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        System.out.println(Arrays.toString(paritySwap1(array)));
        paritySwap2(array);
        System.out.println(Arrays.toString(array));
    }
}
