public interface IA {
    // 1. 先出现 default
    // 2. 接口中的默认方法：add() 不再是抽象方法
    default int add() {
        return 10;
    }
}
