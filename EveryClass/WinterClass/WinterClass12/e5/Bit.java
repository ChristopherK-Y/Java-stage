package javase.learn_extends.e5;

// 承诺要做到培训服务
// 在 Java 中表现就是，Bit 类实现（implements）了TrainService接口
public class Bit implements TrainService {
    @Override
    public void learnJava() {
        System.out.println("比特的方式教 Java");
    }

    @Override
    public void trainOffer() {
        System.out.println("比特的方式，进行就业培训");
    }
}
