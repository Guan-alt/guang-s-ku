/**
 * ClassName: ThreadCallDemo
 * Package: PACKAGE_NAME
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/29 - 8:57
 */
public class ThreadCallDemo {
    public static void main(String[] args) {
        final Object obj = new Object();
        new Thread() {
            @Override
            public void run() {
                synchronized (obj) {
                    System.out.println("告知老板想吃的包子种类和数量");
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("包子做好了，开吃！");
                    System.out.println("======================");
                }
            }
        }.start();

        //生产者线程
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (obj) {
                    System.out.println("老板花了5秒做好包子，\n老板：包子做好啦！");
                    System.out.println("=================");
                    obj.notify();
                }
            }
        }.start();
    }
}
