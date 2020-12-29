import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        int level = getLevel();
        int range = getRange(level);
        int rand = getRandom(range);
        int toGuessCount = getGuessCount(level);

        play(rand, toGuessCount);
    }

    private static void play(int rand, int toGuessCount) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        while (scanner.hasNextInt() && toGuessCount > 0) {
            int x = scanner.nextInt();
            if (x == rand) {
                System.out.println("Guess right!");
                return;
            } else if (x < rand) {
                System.out.println("Little");
            } else {
                System.out.println("Big");
            }
            toGuessCount--;
            System.out.print("Please enter a number:");
        }
    }

    private static int getGuessCount(int level) {
        int count;
        switch (level) {
            case 1:
                count = 5;
                break;
            case 2:
                count = 10;
                break;
            case 3:
                count = 50;
                break;
            default:
                count = 20;
        }
        return count;
    }

    private static int getRandom(int range) {
        Random random = new Random();
        return random.nextInt(range);
    }

    private static int getRange(int level) {
        int range;
        switch (level) {
            case 1:
                range = 10;
                break;
            case 2:
                range = 100;
                break;
            case 3:
                range = 1000;
                break;
            default:
                range = 50;
        }
        return range;
    }

    private static int getLevel() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


}
