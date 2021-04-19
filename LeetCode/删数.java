package NowCoder;

import java.util.*;

public class 删数 {
    private static int deleteIndex = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            deleteIndex = 0;
            System.out.println(fun(n));
        }
    }

    private static void increase(int n) {
        deleteIndex++;
        deleteIndex %= n;
    }

    private static int fun(int n) {
        short[] array = new short[n];
        for (int i = 0; i < n; i++) {
            array[i] = (short) i;
        }
        int length = n;
        while (length > 1) {
            for (int i = 0; i < 2; i++) {
                while (array[deleteIndex] == -1) {
                    increase(n);
                }
                increase(n);
            }
            while (array[deleteIndex] == -1) {
                increase(n);
            }
            array[deleteIndex] = -1;
            increase(n);
            length--;
        }
        for (short i : array) {
            if (i != -1) {
                return i;
            }
        }
        return -1;
    }
}
