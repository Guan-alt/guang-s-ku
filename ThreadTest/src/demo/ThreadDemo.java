package demo;

/**
 * ClassName: ThreadDemo
 * Package: demo
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/28 - 9:18
 */
public class ThreadDemo extends Thread {
    private int ticket = 10;
    private String name;

    public ThreadDemo() {
    }

    public ThreadDemo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
//        synchronized (this) {
        for (int i = 1; i <= 10; i++) {
            synchronized (this) {
                if (ticket > 0) {
                    String str = this.name;
                    System.out.println(str + "卖出了第" + ticket + "张票");
                    ticket--;
                }
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
//        }
    }
}
