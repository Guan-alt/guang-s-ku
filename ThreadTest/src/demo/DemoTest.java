package demo;

/**
 * ClassName: DemoTest
 * Package: demo
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/28 - 9:17
 */
public class DemoTest {
    public static void main(String[] args) {
//        ThreadTest();
        RunnableTest();
    }

    public static void ThreadTest(){
        ThreadDemo t1 = new ThreadDemo("窗口一");
        ThreadDemo t2 = new ThreadDemo("窗口二");
        ThreadDemo t3 = new ThreadDemo("窗口三");
        t1.start();
        t2.start();
        t3.start();
    }

    public static void RunnableTest(){
        RunnableImplDemo run = new RunnableImplDemo();
        Thread t1 = new Thread(run,"窗口一");
        Thread t2 = new Thread(run,"窗口二");
        Thread t3 = new Thread(run,"窗口三");
        t1.start();
        t2.start();
        t3.start();
    }
}
