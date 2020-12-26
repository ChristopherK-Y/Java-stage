import java.util.Scanner;

public class NumberJinZiTa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ch = scanner.next();
        for (int i = 0; i < 6; i++) {
            for (int j = 6 - i; j > 0 ; j--) {
                System.out.print(" ");
            }
            for (int k = 0; k < i; k++) {
                System.out.print(ch+" ");
            }
            System.out.println();
        }
    }
}
