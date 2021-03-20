package java_web.thread;

public class MyThreadDemo1 {
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("I'm a thread!");
            while(true){
                //为了使用jConsole查看线程情况
            }
        }
    }

    public static void main(String[] args) {
        MyThread test = new MyThread();
        test.start();
        while(true){
            //为了使用jConsole查看线程情况
        }
    }
}
