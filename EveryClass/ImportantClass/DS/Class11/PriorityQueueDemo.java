import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {
    static class IntegerComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    }

    // 甲 乙 丙 丁 戊 己 庚 辛 壬 癸

    public static void main(String[] args) {
        Queue<String> queue = new PriorityQueue<>(new TianGanComparator());
        queue.add("乙");
        queue.add("甲");
        queue.add("癸");
        queue.add("壬");
        queue.add("丁");
        queue.add("丙");

        System.out.println(queue.remove()); // 甲
        System.out.println(queue.remove()); // 乙
        System.out.println(queue.remove()); // 乙
        System.out.println(queue.remove()); // 乙
        System.out.println(queue.remove()); // 乙
        System.out.println(queue.remove()); // 乙
    }

    static class TianGanComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return transform(o1) - transform(o2);
        }

        private int transform(String s) {
            switch (s) {
                case "甲": return 1;
                case "乙": return 2;
                case "丙": return 3;
                case "丁": return 4;
                case "戊": return 5;
                case "己": return 6;
                case "庚": return 7;
                case "辛": return 8;
                case "壬": return 9;
                case "癸": return 10;
                default: return -1;
            }
        }
    }

    public static void main2(String[] args) {
        Comparator<Integer> comparator = new IntegerComparator();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(comparator);
        Queue<Integer> queue = priorityQueue;

        queue.add(3);
        queue.add(5);
        queue.add(2);
        queue.add(7);
        queue.add(9);

        // 1. Integer 有没有实现过 Comparable? 有
        // 1. PriorityQueue 是大堆还是小堆？    小堆

        System.out.println(queue.remove()); // 2
        System.out.println(queue.remove()); // 3
        System.out.println(queue.remove()); // 5
        System.out.println(queue.remove()); // 7
        System.out.println(queue.remove()); // 9
    }
}
