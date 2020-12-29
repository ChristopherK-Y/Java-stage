import java.util.Scanner;

public class Method {
    //    public static long add(int a, int b) {
//        return a + b;
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNextInt()) {
//            int a = scanner.nextInt();
//            int b = scanner.nextInt();
//            System.out.println(add(a, b));
//        }
//    }


    public static long pow(int n, int m) {
        long result = 1;
        for (int i = 0; i < m; i++) {
            result *= n;
        }
        return result;
    }

    //
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        while (scanner.hasNextInt()) {
//            int n = scanner.nextInt();
//            int m = scanner.nextInt();
//            System.out.println(n + "的" + m + "次方 = " + pow(n, m));
//
//        }
//    }
    public static boolean isDaffodil(int n) {
        int original = n;
        long sum = 0;
        while (n != 0) {
            int last = n % 10;
            n = n / 10;
            sum += pow(last, 3);
        }
        if (sum == original) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number: ");
        while (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            if (isDaffodil(x)) {
                System.out.println("This number is a daffodil number!");
            } else {
                System.out.println("This number is not a daffodil number!");
            }
            System.out.println("Please enter a number:");
        }
    }

}

