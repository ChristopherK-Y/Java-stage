import java.util.Scanner;


//输入ctrl+d hasNext() 才会返回false
public class in {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNextInt()){
            int i = s.nextInt();
            System.out.println(i);
        }
        while (s.hasNextLine()){
            String x = s.nextLine();
            System.out.println(x);
        }

    }
}
