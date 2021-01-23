package 方法的使用_作业;

//6.创建方法求两个数的最大值max2，随后再写一个求3个数的最大值的函数max3。
//要求：在max3这个函数中，调用max2函数，来实现3个数的最大值计算
public class GetMax {
    public static int max2(int x, int y) {
        return Math.max(x, y);
    }

    public static int max3(int x, int y, int z) {
        return max2(max2(x, y), z);
    }

    public static void main(String[] args){
        System.out.println("Max of (3, -2) is: "+max2(3,-2));
        System.out.println("Max of (3, -2, 4) is: "+max3(3,-2,4));
    }
}
