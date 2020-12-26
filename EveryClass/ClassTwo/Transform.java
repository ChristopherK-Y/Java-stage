import java.util.Scanner;

public class Transform {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringNumber = scanner.next();
        long result = Integer.parseInt(stringNumber,16);
        System.out.println("This digit is " + result);


    }
}
