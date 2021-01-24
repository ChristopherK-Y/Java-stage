package my_date_time;

public class MyTime {
    private int hour;
    private int minute;
    private int second;

    public MyTime(int hour, int minute, int second) {
        checkTime(hour, minute, second);
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public MyTime(MyTime time) {
        this.hour = time.hour;
        this.minute = time.minute;
        this.second = time.second;
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public boolean next() {
        second++;
        if (second < 60) {
            return false;
        }
        minute++;
        second = 0;
        if (minute < 60) {
            return false;
        }
        hour++;
        minute = 0;
        if (hour < 24) {
            return false;
        }
        hour = 0;
        return true;
    }

    public boolean previous() {
        second--;
        if (second >= 0) {
            return false;
        }
        minute--;
        second = 59;
        if (minute >= 0) {
            return false;
        }
        hour--;
        minute = 59;
        if (hour >= 0) {
            return false;
        }
        hour = 23;
        return true;
    }

    private void checkTime(int hour, int minute, int second) {
        if (hour < 0 || hour >= 24) {
            throw new RuntimeException("hour 参数输入错误！");
        }
        if (minute < 0 || minute >= 60) {
            throw new RuntimeException("minute 参数输入错误！");
        }
        if (second < 0 || second >= 60) {
            throw new RuntimeException("second 参数输入错误！");
        }
    }
}
