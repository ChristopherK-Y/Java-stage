public class MyDateTest {
    public static void main(String[] args) {
        MyDate from = new MyDate(1999, 10, 18);

        MyDate to = new MyDate(2000, 2, 28);

        System.out.printf("从 %s 到 %s 经过了 %d 天\n", from, to, to.elapsedDay(from));
    }
}
