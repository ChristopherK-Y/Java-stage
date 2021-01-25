package TheGame;

// 实例化一个 Game 对象
// Game 对象的代表的是一局游戏
// 1. initialize
// 2. play
// 3. destroy
public class Game {
    private final Chessboard chessboard;
    private final Player player;
    private final AI ai;

    public Game(Player player) {
        this.chessboard = new Chessboard();
        this.player = player;
        this.ai = new AI();
    }

    // 游戏开始之前，进行一些准备工作
    public void initialize() {
        System.out.println("欢迎进入《井字棋》游戏");
        System.out.println("规则说明如下：省略……");
        System.out.println("=====================================");
        System.out.println(chessboard);
    }

    // 游戏主流程 —— 回合制
    public void play() {
        while (true) {
            // 一个循环 = 玩家回合 + AI回合
            if (playerTurn()) {
                break;
            }

            if (aiTurn()) {
                break;
            }
        }
    }

    // 游戏结束之前，完成一些收尾工作
    public void destroy() {
        chessboard.reset();
    }

    private boolean playerTurn() {
        System.out.println("玩家回合：");

        while (true) {
            int[] rc = player.getRowColumn();
            int row = rc[0];
            int column = rc[1];

            if (chessboard.moveCircleAt(row, column)) {
                break;
            }
            System.out.println("该位置已经有棋子，请重新选择位置");
        }
        System.out.println(chessboard);

        return chessboard.getState() != Chessboard.CONTINUE;
    }

    private boolean aiTurn() {
        System.out.println("AI 回合：");

        while (true) {
            int[] rc = ai.getRowColumn();
            int row = rc[0];
            int column = rc[1];

            if (chessboard.moveCrossAt(row, column)) {
                break;
            }
        }
        System.out.println(chessboard);

        return chessboard.getState() != Chessboard.CONTINUE;
    }
}
