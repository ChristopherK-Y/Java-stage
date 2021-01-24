package my_date_time;

import java.util.concurrent.TimeUnit;

public class MyDateTimeTest {
    public static void main(String[] args) throws InterruptedException {
        MyDate date = new MyDate(2021,1,24);
        MyTime time = new MyTime(17,14,30);
        MyDateTime dateTime = new MyDateTime(date,time);
        while(true){
            System.out.println(dateTime);
            dateTime.next();
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
