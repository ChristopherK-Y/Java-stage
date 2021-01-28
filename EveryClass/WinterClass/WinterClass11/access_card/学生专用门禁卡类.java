package access_card;

public class 学生专用门禁卡类 extends 门禁卡类 {
    @Override
    public void 进出大门() {
        super.进出大门();
        System.out.println("同学们注意安全");
    }
}
