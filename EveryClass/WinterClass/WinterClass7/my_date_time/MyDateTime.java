package my_date_time;

public class MyDateTime {
    private MyDate date;
    private MyTime time;

    public MyDateTime(MyDate date, MyTime time) {
        this.date = new MyDate(date);
        this.time = new MyTime(time);
    }

    public MyDateTime(MyDateTime dateTime) {
        date = new MyDate(dateTime.date);
        time = new MyTime(dateTime.time);
    }

    public MyDateTime(int year, int month, int day, int hour, int minute, int second) {
        date = new MyDate(year, month, day);
        time = new MyTime(hour, minute, second);
    }

    public String toString() {
        return date.toString() +" "+ time.toString();
    }

    public void next(){
        if(time.next()){
            date.next();
        }
    }

    public void previous(){
        if(time.previous()){
            date.previous();
        }
    }
}
