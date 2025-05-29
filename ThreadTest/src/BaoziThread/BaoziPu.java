package BaoziThread;

/**
 * ClassName: BaoziPu
 * Package: BaoziThread
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/29 - 9:31
 */
public class BaoziPu extends Thread{
    private Baozi baozi;//包子的映射

    //包子铺的无参构造方法（一般情况没啥用）
    public BaoziPu() {
        super();
    }
    //包子铺的有参构造方法，通过传入类对象继承类对象的属性以及方法
     public BaoziPu(Baozi baozi) {
        super();
        this.baozi = baozi;
    }

    @Override
    public void run(){
        //计数器，用于改变包子类型
        int count = 0;
        while (true){
            //通过synchronized方法，以baozi为对象锁，给线程上锁
            /**
             * 代码中使用 baozi 作为对象锁，是为了实现 生产者和消费者线程对共享包子状态的同步控制
             * 1. 锁对象的选择原则
             * 共享性：baozi 是生产者和消费者共同操作的共享资源（包子状态）
             * 唯一性：所有线程必须操作同一个 baozi 实例（否则锁失效）
             * 可见性：baozi 的状态变化需被所有线程感知（通过 volatile 或同步机制）
             */
            //先会判断线程是否有锁对象，有才会进入synchronized包裹的代码块
            synchronized (baozi){
                //判断是否有包子，有包子则让线程进入等待状态
                if(baozi.isFlag()){
                    try {
                        //用wait方法使线程进入等待状态，同时释放锁对象
                        baozi.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }else {
                    if(count % 2 == 0){
                        baozi.setBaozip("薄皮");
                        baozi.setBaozix("猪肉");
                    }else {
                        baozi.setBaozip("冰皮");
                        baozi.setBaozix("豆沙");
                    }
                    count++;
                    System.out.println("包子铺正在做"+baozi.getBaozip()+baozi.getBaozix()+"包子");
                    try {
                        //模拟做包子过程
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("包子做好啦！吃货开炫！");
                    //修改包子状态
                    baozi.setFlag(true);
                    //唤醒其他线程
                    baozi.notify();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("=====================");

                }
            }
        }
    }
}
