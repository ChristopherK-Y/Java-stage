import java.util.Scanner;

public class TheNumberOfOne {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNextInt()) {
//            int count1 = 0;//奇数位的1的个数
//            int count2 = 0;//偶数位的1的个数
//            int x = scanner.nextInt();
//            System.out.println(Integer.toBinaryString(x));
//            for (int i = 0; i < 32; i++) {
//                if ((x & (1 << i)) != 0) {
//                    count1++;
//                }
//                i++;
//                if ((x & (1 << i)) != 0) {
//                    count2++;
//                }
//            }
//            System.out.println("奇数位" + count1);
//            System.out.println("偶数位" + count2);
//
//        }
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int count = 0;
            int x = scanner.nextInt();
            while (x != 0) {
                x = x & (x - 1);
                count++;
            }
            System.out.println("1的个数有：" + count);
        }
    }
}
