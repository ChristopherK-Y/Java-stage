package NowCoder;

import java.util.*;

public class 最大公因数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int in1 = sc.nextInt();
        int in2 = sc.nextInt();
        int x = findSmall(in1, in2);
        System.out.println((in1 * in2 / x));
    }

    /**
     * 最大公因数
     * @param in1 数1
     * @param in2 数2
     * @return 最大公因数
     */
    private static int findSmall(int in1, int in2) {
        int max = Math.max(in1, in2);
        int min = Math.min(in1, in2);
        int number = min;
        while (number > 0) {
            if (max % number == 0 && min % number == 0) {
                return number;
            }
            number--;
        }
        return -1;
    }
}

