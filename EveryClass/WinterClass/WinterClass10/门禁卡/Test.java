package 门禁卡;

public class Test {
    public static void main(String[] args) {
        老师专用门禁卡 c1 = new 老师专用门禁卡();

        学生专用门禁卡 c2 = new 学生专用门禁卡();

        c1.进出大门();

        c2.进出大门();
    }
}
