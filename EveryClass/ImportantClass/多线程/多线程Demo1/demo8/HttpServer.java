package demo8;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class HttpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();

            //new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException exc) {
                }


                try {
                    OutputStream os = socket.getOutputStream();
                    Writer writer = new OutputStreamWriter(os, "UTF-8");
                    PrintWriter printWriter = new PrintWriter(writer);

                    printWriter.print("HTTP/1.0 200 OK\r\n");
                    printWriter.print("Content-Type: text/plain; charset=utf-8\r\n");
                    printWriter.print("\r\n");
                    printWriter.print("你好世界");
                    printWriter.flush();
                    socket.close();
                } catch (IOException exc) {
                }
            //}).start();
        }
    }
}
