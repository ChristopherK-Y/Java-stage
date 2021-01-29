package javase.learn_extends.e5;

// 定义了接口
// 完全理解成定义了一个抽象类 TrainService
// 1. 接口不能直接实例化成对象
// 2. 允许并且只允许，出现抽象方法
public interface TrainService {
    // 定义的所有方法，都是抽象方法
    // 虽然没写，但隐含一个 abstract 修饰
    // 隐含着访问限定符都是 public
    void learnJava();

    void trainOffer();
}
