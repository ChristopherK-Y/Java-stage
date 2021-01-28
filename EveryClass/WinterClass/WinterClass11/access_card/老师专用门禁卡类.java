package access_card;

public class 老师专用门禁卡类 extends 门禁卡类 {
    @Override
    public void 进出大门() {
        super.进出大门();
        System.out.println("欢迎 XXX 老师");
    }
}
