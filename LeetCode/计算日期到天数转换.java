package NowCoder;

import java.util.*;

public class 计算日期到天数转换 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();
            System.out.println(iConverDateToDay(year, month, day));
        }
    }

    public static int iConverDateToDay(int year, int month, int day) {
        int ans = 0;
        for (int i = 1; i < month; i++) {
            ans += getOutDay(year, i);
        }
        ans += day;
        return ans;
    }

    public static int getOutDay(int year, int month) {
        switch (month) {
            case 1:
                return 31;
            case 2:
                if (isLeapYear(year)) {
                    return 29;
                }
                return 28;
            case 3:
                return 31;
            case 4:
                return 30;
            case 5:
                return 31;
            case 6:
                return 30;
            case 7:
                return 31;
            case 8:
                return 31;
            case 9:
                return 30;
            case 10:
                return 31;
            case 11:
                return 30;
            case 12:
                return 31;
        }
        return -1;
    }

    public static boolean isLeapYear(int year) {
        return year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
    }
}
