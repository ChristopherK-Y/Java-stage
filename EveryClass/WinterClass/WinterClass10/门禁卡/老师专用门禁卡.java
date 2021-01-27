package 门禁卡;

// 老师的门禁卡，除了正常功能之外，最后还需要打出欢迎 XX 老师出来
public class 老师专用门禁卡 extends 门禁卡 {
    // 重写 进出大门功能

    @Override
    public void 进出大门() {
        //System.out.println("老师的门禁卡另起炉灶");
        super.进出大门();       // 先调用父类的方法
        System.out.println("欢迎 XXX 老师");
    }
}
