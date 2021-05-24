package NowCoder;

import java.util.PriorityQueue;

/**
 * 先用java集合PriorityQueue来设置一个小顶堆和大顶堆
 * 主要的思想是：因为要求的是中位数，那么这两个堆，大顶堆用来存较小的数，从大到小排列；
 * 小顶堆存较大的数，从小到大的顺序排序*，显然中位数就是大顶堆的根节点与小顶堆的根节点和的平均数。
 * ⭐保证：小顶堆中的元素都大于等于大顶堆中的元素，所以每次塞值，并不是直接塞进去，而是从另一个堆中poll出一个最大（最小）的塞值
 * ⭐当数目为偶数的时候，将这个值插入大顶堆中，再将大顶堆中根节点（即最大值）插入到小顶堆中；
 * ⭐当数目为奇数的时候，将这个值插入小顶堆中，再讲小顶堆中根节点（即最小值）插入到大顶堆中；
 * ⭐取中位数的时候，如果当前个数为偶数，显然是取小顶堆和大顶堆根结点的平均值；如果当前个数为奇数，显然是取小顶堆的根节点
 */
public class 数据流中的中位数 {
    public PriorityQueue<Integer> min = new PriorityQueue<>();
    public PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);
    public int count = 0;

    public void Insert(Integer num) {
        if ((count & 1) == 0) {
            max.add(num);
            min.add(max.remove());
        } else {
            min.add(num);
            max.add(min.remove());
        }
        count++;
    }

    public Double GetMedian() {
        return (count & 1) == 1 ? new Double(min.peek()) : 1.0 * (max.peek() + min.peek()) / 2;
    }

    public static void main(String[] args) {
        数据流中的中位数 x = new 数据流中的中位数();
        x.Insert(5);
        System.out.println(x.GetMedian());
        x.Insert(2);
        System.out.println(x.GetMedian());
        x.Insert(3);
        System.out.println(x.GetMedian());
        x.Insert(4);
        System.out.println(x.GetMedian());
        x.Insert(1);
        System.out.println(x.GetMedian());
        x.Insert(6);
        System.out.println(x.GetMedian());
        x.Insert(7);
        System.out.println(x.GetMedian());
        x.Insert(0);
        System.out.println(x.GetMedian());
        x.Insert(8);
        System.out.println(x.GetMedian());
    }
}
