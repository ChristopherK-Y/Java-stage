package NowCoder;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/questionTerminal/71d3849a19f04a1591c415964ac148f1
 */
public class 养兔子 {
    public static void main(String[] args) { 
        fun();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            System.out.println(array[sc.nextInt()]);
        }
    }

    private static int[] array = new int[100];

    private static void fun() {
        array[1] = 1;
        array[2] = 2;
        for (int i = 3; i < 100; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
    }
}
