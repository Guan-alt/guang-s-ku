package BaoziThread;

/**
 * ClassName: ChiHuo
 * Package: BaoziThread
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/29 - 18:50
 */
public class ChiHuo extends Thread{
    private Baozi baozi;
    public ChiHuo(){super();}
    public ChiHuo(Baozi baozi){
        super();
        this.baozi = baozi;
    }

    @Override
    public void run(){
        while (true){
            synchronized (baozi){
                if(baozi.isFlag() == false){
                    try {
                        baozi.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }else {
                    System.out.println("吃货正在吃"+baozi.getBaozip()+baozi.getBaozix()+"包子...");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(baozi.getBaozip()+baozi.getBaozix()+"包子吃完了");
                    baozi.setFlag(false);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("=======================");
                    System.out.println("包子铺开始做包子...");
                    baozi.notify();
                }
            }
        }
    }
}
