package demo7;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FibApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane = new GridPane();

        TextField tf = new TextField();
        Button button = new Button("计算");
        TextArea textArea = new TextArea();

        button.setOnAction(event -> {
            int n = Integer.parseInt(tf.getText());
            /*
            new Thread(() -> {
                long r = fib(n);

                Platform.runLater(() -> {
                    textArea.appendText(String.format("fib(%d) = %d\n", n, r));
                });
            }).start();

             */
            long r = fib(n);
            textArea.appendText(String.format("fib(%d) = %d\n", n, r));
        });

        gridPane.addRow(0, tf, button);
        gridPane.addRow(1, textArea);

        Scene scene = new Scene(gridPane);
        primaryStage.setTitle("fib");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static long fib(int n) {
        if (n < 2) {
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }
}
