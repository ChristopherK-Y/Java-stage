package LeetCode;

import java.util.*;

class MagicTower {
    public int magicTower(int[] nums) {
        long health = 1;
        int count = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();//小顶堆
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                health += nums[i];
            } else {
                heap.add(nums[i]);
                health += nums[i];
                if (health <= 0) {
                    int t = heap.remove();
                    list.add(t);
                    count++;
                    health += -t;
                }
            }
        }
        int sum = 0;
        for (int one : list) {
            sum += one;
        }
        if (sum + health <= 0) {
            return -1;
        }
        return count;
    }
}
