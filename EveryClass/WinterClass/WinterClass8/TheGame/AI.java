package TheGame;

import java.util.Random;

// 生成 AI 的落子位置
public class AI {
    private final Random random = new Random();

    // 第几行、第几列都是从 0 开始
    // 有效取值 [0, 2]
    // new int[] { 第几行, 第几列 }
    public int[] getRowColumn() {
        int r = random.nextInt(3);
        int c = random.nextInt(3);

        return new int[] {r, c};
    }
}
