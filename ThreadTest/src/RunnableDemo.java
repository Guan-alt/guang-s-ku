/**
 * ClassName: RunnableDemo
 * Package: PACKAGE_NAME
 * Dscription:创建一个线程，最简单的方法是创建一个实现 Runnable 接口的类，
 * 如果要在主方法调用这个方法，只要调用start方法就可同步调用run方法的代码
 *
 * @Author: gw
 * @Creat: 2025/5/26 - 19:26
 */
public class RunnableDemo implements Runnable{
    private Thread t;
    private String ThreadName;

    public RunnableDemo(String threadName) {
        ThreadName = threadName;
        System.out.println("Creating thread:"+threadName);
    }

    //调用的主要就是这里面的代码
    @Override
    public void run() {
        System.out.println("Running:"+ThreadName);
        for (int i = 0; i < 4; i++) {
            System.out.println("Thread:"+i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //检测这个线程是否被调用，若没调用再调用这个线程，避免线程重复启动
    public void start(){
        System.out.println("Start:"+ThreadName);
        if(t == null){
            t = new Thread(this,ThreadName);
            t.start();
        }
    }

    public static void main(String[] args) {
        RunnableDemo demo = new RunnableDemo("Thread1");
        demo.start();

        RunnableDemo demo1 = new RunnableDemo("Thread2");
        demo1.start();
    }
}
