import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Random rand = new Random();
        int r = rand.nextInt(100);
        int count = 5;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt() && count > 0) {
            System.out.println("Please enter the number:");
            int n = scanner.nextInt();
            System.out.println("You have " + count + " choice");
            count ++;
            if (n == r) {
                System.out.println("Right");
                break;
            } else if (n < r) {
                System.out.println("Little");
            } else {
                System.out.println("Big");
            }
        }
    }
}
