import java.util.Scanner;

public class OutStudent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        String age = scanner.next();
        String gender = scanner.next();
        System.out.println("Name    Age    Gender");
        for (int i = 0; i < 21; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.printf("%-8s%-7s%s", name,age,gender);
    }
}
