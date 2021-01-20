public class MyDate {
    public int year;
    public int month;
    public int day;

    public int intervalDay(MyDate from) {
        int toDay = this.year * 365 + this.month * 30 + this.day;
        int fromDay = from.year * 365 + from.month * 30 + from.day;
        return toDay - fromDay;
    }
}
