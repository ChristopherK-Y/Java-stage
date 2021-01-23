package 方法的使用_作业;

//7.在同一个类中定义多个方法：要求不仅可以求两个整数的最大值，还可以求两个小数的最大值，以及两个小数和一个整数的大小关系
public class GetMaxOverLoad {
    public static int max2(int x, int y) {
        return Math.max(x, y);
    }

    public static double max2(double x, double y) {
        return Math.max(x, y);
    }

    public static void main(String[] args) {
        System.out.println("Max of (3.12, 2.34, 5)" + max2(max2(3.12, 2.34), 5));
    }
}
