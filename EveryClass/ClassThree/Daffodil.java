import java.util.Scanner;

public class Daffodil {
    public static void daffodil(String[] args) {
        for (int i = 100; i <= 999; i++) {
            int sum = 0;
            int t = i;
            while (t != 0) {
                int last = t % 10;
                t = t / 10;
                sum += last * last * last;
            }
            if (sum == i) {
                System.out.println(i);
            }
        }
    }
}
