package LeetCode;

import java.util.*;


class KSmallestPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new LinkedList<>();
        PriorityQueue<List<Integer>> bigHeap = new PriorityQueue<>(k, (list1, list2) -> {
            return list2.get(0) + list2.get(1) - list1.get(0) - list1.get(1);
        });//大顶堆

        for (int i = 0; i < Math.min(nums1.length, k); i++) {//暴力都走一遍
            for (int j = 0; j < Math.min(nums2.length, k); j++) {
                int temp = nums1[i] + nums2[j];//当前的两数之和
                if (bigHeap.size() == k && bigHeap.peek().get(0) + bigHeap.peek().get(1) <= temp) {
                    break;//如果当前的和比大顶堆的堆顶都大,那么就没有意义了
                }
                if (bigHeap.size() == k) {//堆满的时候,需要把堆顶去了
                    bigHeap.remove();
                }
                //堆没满入堆即可
                List<Integer> willAdd = new ArrayList<>();
                willAdd.add(nums1[i]);
                willAdd.add(nums2[j]);
                bigHeap.add(willAdd);
            }
        }
        while (!bigHeap.isEmpty()) {//逆序插入
            ans.add(0, bigHeap.remove());
        }
        return ans;
    }
}