package access_card;

public class Main {
    public static 门禁卡类[] 制造一批门禁卡() {
        门禁卡类[] array = new 门禁卡类[10];

        for (int i = 0; i < 5; i++) {
            门禁卡类 o = new 学生专用门禁卡类();        // 向上转型
            array[i] = o;
        }

        for (int i = 5; i < 10; i++) {
            门禁卡类 o = new 老师专用门禁卡类();        // 向上转型
            array[i] = o;
        }

        return array;
    }

    // 相同的东西，表现不同的形态 —— 多态
    public static void main(String[] args) {
        门禁卡类[] array = 制造一批门禁卡();

        for (门禁卡类 o : array) {
            // 目前 o 指向的对象，可能是老师专用的 OR 学生专用的
            o.进出大门();   // 跟着对象类型走
                            // 前 5 个是学生，后 5 个是老师
            System.out.println("=========================");
        }
    }
}
