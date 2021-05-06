package NowCoder;

import java.util.*;

public class 杨辉三角的变形 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            for (int i = 1; i <= 2 * n - 1; i++) {
                if ((func(n, i) & 1) == 0) {
                    System.out.println(i);
                    break;
                }
            }
            if (n == 2 * n) {
                System.out.println(-1);
            }
        }
    }

    private static int func(int n, int i) {
        if (i == 1 || i == 2 * n - 1) {
            return 1;
        } else if (i < 1 || i > 2 * n - 1) {
            return 0;
        } else {
            return func(n - 1, i - 1) + func(n - 1, i - 2) + func(n - 1, i);
        }
    }
}
