package demo9;

public class ThreadDemo {
    public static void main(String[] args) {
        // 计算 0 + 1 + 2 + 3 + ... + 100W)
        // 这个计算持续 10 次
        // 计算其耗时情况
        long b = System.currentTimeMillis();
        // 创建出 9 个线程，去分别进行计算
        for (int i = 0; i < 10; i++) {
            long r = 0;
            for (long j = 0; j < 1_0000_0000L; j++) {
                r += j;
            }
            System.out.println("计算结束");
        }
        // 自己算一遍
        // 等待其他 9 个线程也计算完

        long e = System.currentTimeMillis();
        double t = (e - b) / 1000.0;
        System.out.printf("耗时: %.4f s", t);
    }
}
