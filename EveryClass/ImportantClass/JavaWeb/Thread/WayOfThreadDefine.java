package java_web.thread;

public class WayOfThreadDefine {
    public static void main(String[] args) {
        //1.定义一个类继承Thread类
        class ForThread extends Thread {
            @Override
            public void run() {
                System.out.println("This is t1 thread!");
            }
        }
        ForThread t1 = new ForThread();
        t1.start();

        //2.匿名内部类继承Thread类
        Thread t2 = new Thread(){
            @Override
            public void run() {
                System.out.println("This is t2 thread!");
            }
        };
        t2.start();

        //3.定义一个类，实现Runnable接口
        class MyRunnable implements Runnable{
            @Override
            public void run() {
                System.out.println("This is t3 thread!");
            }
        }
        Thread t3 = new Thread(new MyRunnable());
        t3.start();

        //4.匿名内部类实现Runnable接口
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("This is t4 thread!");
            }
        });
        t4.start();

        //5.lambda表达式
        Thread t5 = new Thread(()->{
            System.out.println("This is t5 thread!");
        });
        t5.start();
    }
}
