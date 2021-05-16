package NowCoder;

import java.util.LinkedList;
import java.util.Scanner;



/*
https://www.nowcoder.com/questionTerminal/cf24906056f4488c9ddb132f317e03bc
 */
class OneStep {
    public int x;
    public int y;

    public OneStep(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


public class 迷宫问题 {
    public static LinkedList<OneStep> path = new LinkedList<>();
    public static LinkedList<OneStep> best_path = new LinkedList<>();
    public static int[][] maze;
    public static int n;
    public static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            path.clear();
            best_path.clear();
            n = sc.nextInt();
            m = sc.nextInt();
            int[][] maze1 = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    maze1[i][j] = sc.nextInt();
                }
            }
            maze = maze1;
            start(0, 0);
            while (!best_path.isEmpty()) {
                OneStep oneStep = best_path.removeLast();
                System.out.println("(" + oneStep.x + "," + oneStep.y + ")");
            }
        }
    }

    private static void start(int x, int y) {
        maze[x][y] = 1;
        path.push(new OneStep(x, y));
        if (x == n - 1 && y == m - 1) {
            if (best_path.isEmpty() || path.size() < best_path.size()) {
                best_path = new LinkedList<>(path);
            }
        }

        if (x - 1 >= 0 && maze[x - 1][y] == 0) {
            start(x - 1, y);
        }
        if (x + 1 < n && maze[x + 1][y] == 0) {
            start(x + 1, y);
        }
        if (y - 1 >= 0 && maze[x][y - 1] == 0) {
            start(x, y - 1);
        }
        if (y + 1 < m && maze[x][y + 1] == 0) {
            start(x, y + 1);
        }

        maze[x][y] = 0;
        path.pop();
    }
}
