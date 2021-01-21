public class MyDate {
    public int year;
    public int month;
    public int day;

    public MyDate(int year, int month, int day) {
        if (year < 1 || year > 9999 || month < 1 || month > 12 || day < 1 || day > getMonthDay(year, month)) {
            throw new RuntimeException("参数错误，请重新校验参数的输入");
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public MyDate(MyDate from) {
        this.year = from.year;
        this.month = from.month;
        this.day = from.day;
    }

    public int getMonthDay(int year, int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
                return getTwoDay(year);
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return -1;
        }
    }

    public int getTwoDay(int year) {
        return isLeapYear(year) ? 29 : 28;
    }

    public boolean isLeapYear(int year) {
        return year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
    }

    public int elapsedDay(MyDate from) {
        if (compareDate(from) <= 0) {
            throw new RuntimeException("日期应该先于当前日期");
        }
        MyDate fromCopy = new MyDate(from);
        int count = 0;
        while (fromCopy.compareDate(this) < 0) {
            System.out.println(fromCopy);
            fromCopy.increment();
            count++;
        }
        return count;
    }

    public void increment() {
        day++;
        if (day <= getMonthDay(year, month)) {
            // day 不需要考虑进位
            return;
        }

        // day 需要考虑日期进位
        month++;
        day = 1;

        if (month <= 12) {
            // month 不需要考虑进位
            return;
        }

        year++;
        month = 1;
    }

    public int compareDate(MyDate from) {
        if (year != from.year) {
            return year - from.year;
        } else if (month != from.month) {
            return month - from.month;
        } else {
            return day - from.day;
        }
    }

    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }
}
