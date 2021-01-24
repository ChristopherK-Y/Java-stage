package my_date_time;

public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        checkDate(year, month, day);
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public MyDate(MyDate date) {
        this.year = date.year;
        this.month = date.month;
        this.day = date.day;
    }

    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    public void next() {
        day++;
        if (day <= getDayOfMonth(year, month)) {
            return;
        }
        month++;
        day = 1;
        if (month <= 12) {
            return;
        }
        year++;
    }

    public void previous() {
        day--;
        if (day > 0) {
            return;
        }
        month--;
        if (month > 0) {
            day = getDayOfMonth(year, month);
            return;
        }
        year--;
        month = 12;
        day = getDayOfMonth(year, month);
    }

    private void checkDate(int year, int month, int day) {
        if (day < 0 || day > getDayOfMonth(year, month)) {
            throw new RuntimeException("day 参数输入不合法！");
        }
        if (month < 0 || month > 12) {
            throw new RuntimeException("month 参数输入不合法！");
        }
        if (year < 0) {
            throw new RuntimeException("year 参数输入不合法！");
        }
    }

    private static final int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private int getDayOfMonth(int year, int month) {
        if (month == 2) {
            return isLeapYear(year) ? (days[1] + 1) : (days[1]);
        } else {
            return days[month - 1];
        }
    }

    private boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}
