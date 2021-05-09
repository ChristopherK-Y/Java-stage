package NowCoder;

import java.util.*;

public class 汽水瓶 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            if(n == 0){
                return;
            }
            System.out.println(func(n));
        }
    }

    private static int func(int n) {
        if (n < 2) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            return (n / 3) + func(n % 3 + n / 3);
        }
    }
}
