import java.util.Scanner;

public class TimeTransform {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int time = scanner.nextInt(); 
        int s = time % 60;
        int m = (time / 60) % 60;
        int h = time / 60 / 60;
        System.out.println(h + ":" + m + ":" + s);
    }
}
