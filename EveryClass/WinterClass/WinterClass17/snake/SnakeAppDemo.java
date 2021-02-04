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
import javafx.stage.Stage;

public class SnakeAppDemo extends Application {
//    //在静态内部类中，可以直接访问我的其他内部静态属性
//    static class MyTimer extends AnimationTimer {
//        private long lastTick = 0;
//        private Canvas canvas;
//        private GraphicsContext gc;
//
//        MyTimer(Canvas canvas, GraphicsContext gc) {
//            this.canvas = canvas;
//            this.gc = gc;
//        }
//
//        @Override
//        public void handle(long now) {
//            //now:以纳秒为单位，本次调用handle时间
//            if (lastTick == 0 || now - lastTick > 1e9 / 48) {
//                lastTick = now;
//                gc.setFill(Color.WHITE);
//                gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
//
//                gc.setFill(Color.RED);
//                gc.fillOval(x, y, 50, 50);
//
//                x++;
//                y++;
//            }
//        }
//    }

    private static int x = 400;//绘制圆的x
    private static int y = 300;//绘制圆的y
    enum Direction {
        DIR_UP, DIR_LEFT, DIR_DOWN, DIR_RIGHT
    }
    private static Direction direction = Direction.DIR_LEFT;


    @Override
    public void start(Stage primaryStage) throws Exception {
        Canvas canvas = new Canvas(800, 600);//画布对象
        Pane pane = new Pane();
        pane.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

//        gc.setFill(Color.RED);
//        gc.fillRect(100, 60, 120, 80);
//
//        gc.setStroke(Color.BLUE);
//        gc.setLineWidth(5);
//        gc.strokeRect(400, 60, 120, 80);
//
//        gc.setFill(Color.LIGHTGREEN);
//        gc.fillOval(100, 200, 80, 80);
//
//        gc.setFill(Color.YELLOW);
//        gc.fillRect(140, 240, 120, 80);

        //AnimationTimer timer = new MyTimer(canvas, gc);
        AnimationTimer timer = new AnimationTimer() {
            long lastTick;
            @Override
            public void handle(long now) {
                if (lastTick == 0 || now - lastTick > 1e9 / 48) {
                    lastTick = now;

                    gc.setFill(Color.WHITE);
                    gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

                    gc.setFill(Color.RED);
                    gc.fillOval(x, y, 50, 50);

                    switch (direction) {
                        case DIR_UP:
                            y--;
                            break;
                        case DIR_LEFT:
                            x--;
                            break;
                        case DIR_DOWN:
                            y++;
                            break;
                        case DIR_RIGHT:
                            x++;
                            break;
                    }
                }
            }
        };
        timer.start();// 调用 start()，启动定时器

        Scene scene = new Scene(pane);
        // 为 scene 绑定键盘按下事件
        // 每当键盘上有 键 按下时，怎么办
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                //System.out.println(event.getEventType() + ":" + event.getCode());

                switch (event.getCode()) {
                    case W: case UP:
                        direction = Direction.DIR_UP;
                        break;
                    case A: case LEFT:
                        direction = Direction.DIR_LEFT;
                        break;
                    case S: case DOWN:
                        direction = Direction.DIR_DOWN;
                        break;
                    case D: case RIGHT:
                        direction = Direction.DIR_RIGHT;
                        break;
                }
            }
        });
        primaryStage.setScene(scene);
        primaryStage.setTitle("贪吃蛇");
        primaryStage.show();
    }
    //primaryStage->scene->pane->canvas->gc

    public static void main(String[] args) {
        //Application.launch(SnakeApp.class, args);
        launch(args);
    }
}
