package day02;

import java.util.Arrays;

public class RemoveElements {
    public int removeElement(int[] nums, int val) {
        int length = 0;
        for (int i = 0; i < nums.length; i++) {//遍历整个数组，如果找到一个不等于val的数，就把他存住，而且length++
            if (nums[i] != val) {
                nums[length] = nums[i];
                length++;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        RemoveElements test = new RemoveElements();
        int[] array = {3, 3};
        System.out.println(test.removeElement(array, 5));
        System.out.println(Arrays.toString(array));

    }
}
