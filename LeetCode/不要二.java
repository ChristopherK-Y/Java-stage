package NowCoder;

import java.util.*;

public class 不要二 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int w = sc.nextInt();
            int h = sc.nextInt();
            int max = Math.max(w, h);
            int four = max / 4;
            int yu = max % 4;
            int oneLine = 2 * four;
            int sum = 0;
            switch (yu) {
                case 0:
                    break;
                case 1:
                    oneLine += 1;
                    break;
                case 2:
                case 3:
                    oneLine += 2;
                    break;
            }

            int four2;
            int yu2;
            //part2:
            if (w >= h) {
                four2 = h / 4;
                yu2 = h % 4;
                sum = w * 2 * four2;
                switch (yu2) {
                    case 0:
                        break;
                    case 1:
                        sum += oneLine;
                        break;
                    case 2:
                        sum += 2 * oneLine;
                        break;
                    case 3:
                        sum += 2 * oneLine + (w - oneLine);
                        break;
                }

            } else {
                four2 = w / 4;
                yu2 = w % 4;
                sum = h * 2 * four2;
                switch (yu2){
                    case 0:
                        break;
                    case 1:
                        sum += oneLine;
                        break;
                    case 2:
                        sum += 2 * oneLine;
                        break;
                    case 3:
                        sum += 2 * oneLine + (h - oneLine);
                        break;
                }
            }

            System.out.println(sum);
        }
    }
}
