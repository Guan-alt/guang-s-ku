/**
 * ClassName: ThreadDemo
 * Package: PACKAGE_NAME
 * Dscription:创建一个线程的第二种方法是创建一个新的类，该类继承 Thread 类，然后创建一个该类的实例。
 *
 * 继承类必须重写 run() 方法，该方法是新线程的入口点。它也必须调用 start() 方法才能执行。
 *
 * 该方法尽管被列为一种多线程实现方式，但是本质上也是实现了 Runnable 接口的一个实例。
 *
 * @Author: gw
 * @Creat: 2025/5/26 - 19:38
 */
public class ThreadDemo extends Thread{
    private Thread t;
    private String ThreadName;

    public ThreadDemo(String name){
        ThreadName = name;
        System.out.println("Creating :"+name);
    }

    public void run(){
        System.out.println("Running"+ThreadName);
        for (int i = 0; i < 4; i++) {
            System.out.println("Thread:"+i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void start(){
        System.out.println("Start:"+ThreadName);
        if(t == null){
            t = new Thread(this,ThreadName);
            t.start();
        }
    }


    public static void main(String[] args) {
        ThreadDemo t1 = new ThreadDemo("Thread1");
        t1.start();

        ThreadDemo t2 = new ThreadDemo("Thread2");
        t2.start();
    }
}
