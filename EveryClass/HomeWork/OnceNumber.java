package 方法的使用_作业;

public class OnceNumber {
    //1.有一组数据，只有一个数字是出现一次，其他是两次，请找出这个数字。
    public static int onceNumber(int[] array) {
        int ans = 0;
        for (int number : array) {
            ans ^= number;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 4, 3, 2, 1};
        System.out.println(onceNumber(array));
    }
}
