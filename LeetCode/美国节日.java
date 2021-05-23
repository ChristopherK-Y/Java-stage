package NowCoder;

import java.util.*;

/**
 * https://www.nowcoder.com/questionTerminal/d95d98a2f96e49078cd7df84ba0c9d79
 */
public class 美国节日 {
    // 根据 年-月-日 通过蔡勒公式计算当前星期几
    public static int day_of_week(int year, int month, int day) {
        if (month == 1 || month == 2) {
            month += 12;
            year -= 1;
        }
        int century = year / 100;
        year %= 100;
        int week = century / 4 - 2 * century + year + year / 4 + (13 * (month + 1)) / 5 + day - 1;
        week = (week % 7 + 7) % 7;
        if (week == 0) {
            week = 7;
        }
        return week;
    }

    // 给定年月和第几周的星期几，求出是该月的几号几号
    public static int day_of_demand(int year, int month, int count, int d_of_week) {
        int week = day_of_week(year, month, 1);// 计算该月1号是星期几
        // 1 + 7(n - 1) + (所求星期数 + 7 - 1号星期数) % 7
        int day = 1 + (count - 1) * 7 + (7 + d_of_week - week) % 7;
        return day;
    }

    // 元旦
    public static void new_year_day(int year) {
        System.out.printf("%d-01-01\n", year);
    }

    // 马丁·路德·金纪念日（1月的第三个星期一）
    public static void martin_luther_king_day(int year) {
        System.out.printf("%d-01-%02d\n", year, day_of_demand(year, 1, 3, 1));
    }

    // 总统日（2月的第三个星期一）
    public static void president_day(int year) {
        System.out.printf("%d-02-%02d\n", year, day_of_demand(year, 2, 3, 1));
    }

    // 阵亡将士纪念日（5月的最后一个星期一）
    public static void memorial_day(int year) {
        // 从 6 月往前数
        int week = day_of_week(year, 6, 1);
        // 星期一的话，从 31 号往前数 6 天，否则，数 week - 2 天
        int day = 31 - ((week == 1) ? 6 : (week - 2));
        System.out.printf("%d-05-%02d\n", year, day);
    }

    // 国庆
    public static void independence_day(int year) {
        System.out.printf("%d-07-04\n", year);
    }

    // 劳动节（9月的第一个星期一）
    public static void labor_day(int year) {
        System.out.printf("%d-09-%02d\n", year, day_of_demand(year, 9, 1, 1));
    }

    // 感恩节（11月的第四个星期四）
    public static void thanks_giving_day(int year) {
        System.out.printf("%d-11-%02d\n", year, day_of_demand(year, 11, 4, 4));
    }

    // 圣诞节
    public static void christmas(int year) {
        System.out.printf("%d-12-25\n\n", year);
    }

    // 美国节日
    public static void holiday_of_usa(int year) {
        new_year_day(year);
        martin_luther_king_day(year);
        president_day(year);
        memorial_day(year);
        independence_day(year);
        labor_day(year);
        thanks_giving_day(year);
        christmas(year);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            holiday_of_usa(sc.nextInt());
        }
    }
}

