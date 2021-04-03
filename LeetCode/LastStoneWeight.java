package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        //优先级队列是小顶堆，需要传入自定义Comparator，完成大顶堆的构建
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        //遍历数组构建堆
        for (int oneElement : stones) {
            heap.add(oneElement);
        }
        //如果还有至少2个元素,那么就进入循环(偶数最后size变为0,奇数变为1)
        while (heap.size() > 1) {
            int y = heap.remove();
            int x = heap.remove();
            if (x != y) {//如果不相等,那么会剩下一个小石头,进入堆
                heap.add(y - x);
            }
        }
        if (heap.isEmpty()) {//堆不为空的话,说明剩一个
            return 0;
        } else {
            return heap.remove();
        }
    }
}
