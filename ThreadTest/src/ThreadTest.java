/**
 * ClassName: ThreadTest
 * Package: PACKAGE_NAME
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/26 - 19:53
 */
public class ThreadTest {
    public ThreadTest() {
        new Thread(){
            @Override
            public void run(){
                for (int i = 0; i < 4; i++) {
                    Hello();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }.start();
    }

    public static void main(String[] args) {
        ThreadTest t = new ThreadTest();
        for (int i = 0; i < 4; i++) {
            System.out.println("test:"+i);
        }
    }
    public static void Hello(){
        System.out.println("Hello");
    }

}
