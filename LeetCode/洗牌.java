package NowCoder;

import java.util.*;

public class 洗牌 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] p = new int[2 * n];
            for (int m = 0; m < 2 * n; m++) {
                p[m] = sc.nextInt();
            }
            for (int j = 0; j < k; j++) {
                xi(p, n);
            }
            for (int l = 0; l < 2 * n - 1; l++) {
                System.out.print(p[l] + " ");
            }
            System.out.println(p[2 * n - 1]);
        }
    }

    private static void xi(int[] p, int n) {
        int[] temp = new int[2 * n];
        int tp = 2 * n - 1;
        int pp = 2 * n - 1;
        for (int i = 0; i < n; i++) {
            temp[tp--] = p[pp];
            temp[tp--] = p[pp - n];
            pp--;
        }
        System.arraycopy(temp, 0, p, 0, 2 * n);
    }
}
