package demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName: RunnableImplTest
 * Package: demo
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/28 - 9:18
 */
public class RunnableImplDemo implements Runnable {
    private int ticket = 10;
    //线程共用的锁对象
    final Object obj = new Object();


    /**
     * 若出现线程安全，保证线程安全的三种方法
     * 1.用synchronized方法把可能会出现线程安全的部分包裹起来，隐性上锁解锁
     * 2.把可能会出现线程安全的部分抽象成一个用synchronized修饰的方法
     * 3.用lock方法，对线程进行显性的上锁解锁
     *维度	          synchronized方法	      抽象为 synchronized方法    Lock显式锁​​
     * 实现复杂度	     低（自动加解锁）	          中（需设计方法结构）	       高（需手动管理锁）
     * 锁粒度	     粗粒度（整个方法）	      中等（可细化到方法内逻辑）	   细粒度（精确到代码行）
     * 性能	         低（阻塞式，JVM 优化后提升） 中等	                   高（非阻塞式，支持自旋）
     * 灵活性	     低（不可中断、无公平性）	  中等	                   高（可中断、公平锁、条件变量）
     * 异常安全	     自动释放锁	              自动释放锁	               需手动释放（依赖 finally）
     * 适用场景	     简单同步、低并发	          复用同步逻辑、解耦业务与锁控制	高并发、复杂同步需求
     */


    //方法一

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                try {
                    if (ticket > 0) {
                        //模拟线程不安全
                        Thread.sleep(20);
                        String str = Thread.currentThread().getName();
                        System.out.println(str + "卖了第" + ticket + "张票");
                        ticket--;
                    }else break;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

   /* //方法二
    @Override
    public void run() {
        while (TicketSell()) {

        }
    }

    public synchronized boolean TicketSell() {
        if (ticket > 0) {
            try {
                //模拟线程不安全
                Thread.sleep(20);
                String str = Thread.currentThread().getName();
                System.out.println(str + "卖了第" + ticket + "张票");
                ticket--;
                return true;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else
            return false;
    }*/
    /*Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            if (ticket > 0) {
                try {
                    Thread.sleep(50);  // 休眠移出同步块
                    String str = Thread.currentThread().getName();
                    System.out.println(str + "窗口卖出了第" + ticket + "张票");
                    ticket--;

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }else {
                lock.unlock();
                break;
            }
        }

    }*/

}