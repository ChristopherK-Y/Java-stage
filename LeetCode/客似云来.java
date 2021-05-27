package NowCoder;

import java.util.*;

public class 客似云来 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            long count = 0;
            for (int i = from; i <= to; i++) {
                count += fun(i);
            }
            System.out.println(count);
        }
    }

    private static long fun(int x) {
        long one = 1;
        long two = 0;
        long three = 0;
        for (int i = 1; i < x; i++) {
            three += two;
            two = one;
            one = three;
        }
        return one + two + three;
    }
}
