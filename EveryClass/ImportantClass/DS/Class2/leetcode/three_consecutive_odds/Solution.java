package leetcode.three_consecutive_odds;

import java.util.ArrayList;

public class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        // int 是基本类型，不能使用到泛型中，所以，使用 int 对应的包装类类型 Integer 替代
        // 从 数组(int[]) 转成顺序表(ArrayList<Integer>)
        ArrayList<Integer> list = new ArrayList<>();
        for (int element : arr) {
            // 因为依次遍历的数组，所以，直接尾插之后，元素的顺序就不会改变
            list.add(element);
        }
        //System.out.println(list);

        // 使用连续的下标: i,j,k 来进行判断
        // i 的取值范围是: [0, size() - 3]
        // j 的取值范围是: [1, size() - 2]
        // k 的取值范围是: [2, size() - 1]
        // k == j + 1 && j == i + 1
        int i = 0;
        int j = 1;
        int k = 2;
        while (k < list.size()) {
            int elementI = list.get(i);
            int elementJ = list.get(j);
            int elementK = list.get(k);

            if (isOdd(elementI) && isOdd(elementJ) && isOdd(elementK)) {
                return true;
            }

            i++;
            j++;
            k++;
        }

        return false;
    }

    private boolean isOdd(int n) {
        return n % 2 != 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = { 1, 3, 5, 7, 9 };
        solution.threeConsecutiveOdds(array);
    }
}
