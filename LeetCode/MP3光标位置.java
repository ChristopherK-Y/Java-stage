package NowCoder;

import java.sql.SQLOutput;
import java.util.*;

public class MP3光标位置 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int num = Integer.parseInt(sc.nextLine());
            String op = sc.nextLine();
            func(num, op);
        }
    }

    private static void func(int num, String op) {
        if (num <= 4) {
            for (int i = 1; i < num; i++) {
                System.out.print(i + " ");
            }
            System.out.println(num);
            int down = 0;
            for (char oneOp : op.toCharArray()) {
                if (oneOp == 'D') {
                    down++;
                } else {
                    down--;
                }
            }
            down += 30000;
            down %= num;
            System.out.println(down + 1);
        } else {
            int top = 1;
            int bottom = 4;
            int now = 1;
            for (char oneOp : op.toCharArray()) {
                if (oneOp == 'U') {
                    now--;
                    if (now < top) {
                        if (top == 1) {
                            top = num - 3;
                            bottom = num;
                            now = bottom;
                        } else {
                            top--;
                            bottom--;
                        }
                    }
                } else {
                    now++;
                    if (now > bottom) {
                        if (bottom == num) {
                            top = 1;
                            bottom = 4;
                            now = 1;
                        } else {
                            top++;
                            bottom++;
                        }
                    }
                }
            }
            for (int i = top; i < bottom; i++) {
                System.out.print(i + " ");
            }
            System.out.println(bottom);
            System.out.println(now);
        }
    }
}
