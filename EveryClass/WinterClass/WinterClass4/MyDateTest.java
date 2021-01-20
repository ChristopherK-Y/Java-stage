public class MyDateTest {
    public static void main(String[] args) {
        MyDate to = new MyDate();
        to.year = 2020;
        to.month = 1;
        to.day = 20;

        MyDate from = new MyDate();
        from.year = 2019;
        from.month = 1;
        from.day = 20;

        System.out.println(to.intervalDay(from));
    }
}
