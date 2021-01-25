package TheGame;

// 提供一个放 mian 方法的位置
public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        Game game = new Game(player);

        while (true) {
            // 一次循环，一局游戏
            game.initialize();

            game.play();

            game.destroy();

            boolean b = player.queryContinue();
            if (!b) {
                System.out.println("欢迎下次继续游戏!");
                break;
            }
        }
    }
}
