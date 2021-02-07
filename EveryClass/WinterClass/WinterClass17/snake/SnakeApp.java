package snake;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;  
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Random;

public class SnakeApp extends Application {
    // 定义需要的变量
    // 定义游戏区域的大小，格子的宽和高
    private static final int WIDTH = 40;
    private static final int HEIGHT = 25;
    // 绘制图形的时候，每个格子所占用的大小
    private static final int GRID_SIZE = 40;
    // 画布的宽和高
    private static final int CANVAS_WIDTH = WIDTH * GRID_SIZE;
    private static final int CANVAS_HEIGHT = HEIGHT * GRID_SIZE;

    // 定义游戏本身
    // 蛇的移动速度
    // speed：每秒的帧数
    // 帧数越高，速度越快
    private static int speed;
    // 食物
    private static Point food = new Point(-1, -1);
    // 蛇
    // 蛇的身体最多可以长到 1000 节
    private static Point[] snake = new Point[1000];
    // 现在蛇有多少节
    private static int snakeLength = 0;
    // 蛇现在的朝向
    enum Direction {
        UP, LEFT, DOWN, RIGHT
    }
    private static Direction direction;
    // 构建一个随机生成器，用于随机出食物的坐标
    private static Random random = new Random();
    // 游戏是否结束标志
    private static boolean gameOver;

    // 用来初始化游戏中的一些数据的
    private static void newGame() {
        speed = 3;
        // 先把蛇回归到原始状态
        Arrays.fill(snake, null);
        snakeLength = 0;
        // 蛇初始形态有 3 节
        snake[snakeLength++] = new Point(WIDTH / 2, HEIGHT / 2);
        snake[snakeLength++] = new Point(WIDTH / 2, HEIGHT / 2);
        snake[snakeLength++] = new Point(WIDTH / 2, HEIGHT / 2);

        // 先有蛇，再有食物
        newFood();

        // 方向初始化成左
        direction = Direction.LEFT;

        // 游戏未结束
        gameOver = false;
    }

    // 用来在地图上随机生成食物
    private static void newFood() {
        // 1. 不能生成到地图外边
        //    x in [0, WIDTH)
        //    y in [0, HEIGHT)
        // 2. 不能和蛇的身体出现碰撞

        int x, y;
        do {
            x = random.nextInt(WIDTH);  // x 的范围一定是 [0, WIDTH)
            y = random.nextInt(HEIGHT); // y 的范围一定是 [0, HEIGHT)
        } while (isCollision(x, y));
        // isCollision(x, y) 返回 true，代表和蛇身体有碰撞，需要重新随机

        // 换言之，能退出循环，肯定不碰撞了
        food.x = x;
        food.y = y;
    }

    // 其实就是一个遍历查找的逻辑
    private static boolean isCollision(int x, int y) {
        // 遍历蛇的每一节身体
        // 不要用 foreach 写法，因为数组中，不是每个位置都是有意义的
        // 只有 [0, snakeLength) 有意义
        for (int i = 0; i < snakeLength; i++) {
            Point point = snake[i];
            if (point.x == x && point.y == y) {
                return true;
            }
        }

        return false;
    }

    // 每一帧，要做的逻辑事宜
    private static void frame() {
        // 移动蛇 —— 移动身体
        for (int i = snakeLength - 1; i >= 1; i--) {
            // 变成前一节的坐标
            snake[i].x = snake[i - 1].x;
            snake[i].y = snake[i - 1].y;
        }
        // 移动蛇 —— 移动头
        Point head = snake[0];
        switch (direction) {
            case UP:
                head.y--;
                break;
            case LEFT:
                head.x--;
                break;
            case DOWN:
                head.y++;
                break;
            case RIGHT:
                head.x++;
                break;
        }

        // 判断蛇走出游戏边界 —— 走出边界，游戏结束
        // head.x in [0, WIDTH) 有效
        // head.y in [0, HEIGHT) 有效
        if (head.x < 0 || head.x >= WIDTH || head.y < 0 || head.y >= HEIGHT) {
            gameOver = true;
            return;
        }
        // 判断蛇有没有碰到自己的身体其他位置 —— 碰到了，游戏结束
        for (int i = 1; i < snakeLength; i++) {
            Point point = snake[i];
            if (head.x == point.x && head.y == point.y) {
                gameOver = true;
                return;
            }
        }

        // 判断有没有吃到食物
        if (head.x == food.x && head.y == food.y) {
            // 如果吃到了食物
            // 1. 蛇的身体增加一节
            // 坐标随便，只要不影响绘图，因为随着下一帧到来，蛇移动之后，坐标就正确了
            snake[snakeLength++] = new Point(-1, -1);
            // 2. 重新生成新的食物
            newFood();
            // 3. 让速度增加
            speed++;
        }
    }

    // 每一帧，要做的绘制工作 —— render（渲染）
    private static void render(GraphicsContext gc) {
        // 1. 通过重新绘制背景，擦除游戏界面
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);

        // 2. 进行蛇的绘制 —— 每一块是一个矩形
        for (int i = 0; i < snakeLength; i++) {
            Point point = snake[i];
            gc.setFill(Color.GREEN);
            // 矩形大小是 GRID_SIZE - 2；上下左右各控一个像素
            gc.fillRect(point.x * GRID_SIZE + 1, point.y * GRID_SIZE + 1, GRID_SIZE - 2, GRID_SIZE - 2);
        }

        // 3. 进行食物的绘制 —— 圆形
        gc.setFill(Color.YELLOW);
        gc.fillOval(food.x * GRID_SIZE, food.y * GRID_SIZE, GRID_SIZE, GRID_SIZE);

        // 4. 进行游戏结束的绘制
        if (gameOver) {
            gc.setFill(Color.RED);
            gc.setFont(new Font(20));
            gc.fillText("游戏结束，再接再厉！", 100, 100);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 进行游戏数据的初始化
        newGame();

        Pane pane = new Pane();
        Canvas canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        pane.getChildren().add(canvas);
        Scene scene = new Scene(pane);

        final GraphicsContext gc = canvas.getGraphicsContext2D();
        AnimationTimer timer = new AnimationTimer() {
            long lastTick;

            @Override
            public void handle(long now) {
                if (gameOver) {
                    return;
                }

                if (lastTick == 0 || now - lastTick > 1e9 / speed) {
                    lastTick = now;
                    frame();
                    render(gc);
                }
            }
        };
        timer.start();

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case W: case UP:
                        if (direction != Direction.DOWN) {
                            direction = Direction.UP;
                        }
                        break;
                    case A: case LEFT:
                        if (direction != Direction.RIGHT) {
                            direction = Direction.LEFT;
                        }
                        break;
                    case S: case DOWN:
                        if (direction != Direction.UP) {
                            direction = Direction.DOWN;
                        }
                        break;
                    case D: case RIGHT:
                        if (direction != Direction.LEFT) {
                            direction = Direction.RIGHT;
                        }
                        break;
                }
            }
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("贪吃蛇");
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
