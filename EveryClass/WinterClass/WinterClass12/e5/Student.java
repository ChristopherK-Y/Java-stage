package javase.learn_extends.e5;

public class Student {
    public static void main(String[] args) {
        // 为就业做准备
        // 上级的引用可以指向下级的对象
        TrainService service1 = new Bit();

        TrainService service2 = new StudySelf();

        service1.learnJava();
        service2.learnJava();
    }
}
