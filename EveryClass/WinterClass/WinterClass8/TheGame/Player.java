package TheGame;

import java.util.Scanner;

// 生成玩家的落子位置
// 询问玩家游戏是否继续
public class Player {
    private final Scanner scanner = new Scanner(System.in);

    // 第几行、第几列都是从 0 开始
    // 有效取值 [0, 2]
    // new int[] { 第几行, 第几列 }
    public int[] getRowColumn() {
        System.out.println("请输入要落子的位置，行 列，有效范围是 [0, 1, 2]");
        int r, c;
        while (true) {
            System.out.print(">>> ");
            r = scanner.nextInt();
            c = scanner.nextInt();

            if (r >= 0 && r <= 2 && c >= 0 && c <= 2) {
                break;
            }

            System.out.println("有效范围是 [0, 1, 2]，请重新输入");
        }

        return new int[] {r, c};
    }

    // 询问用户是否要继续下一把游戏
    public boolean queryContinue() {
        System.out.println("是否开始一局新游戏？true/false");
        System.out.print(">>> ");
        return scanner.nextBoolean();
    }
}
