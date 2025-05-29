package BaoziThread;

/**
 * ClassName: test
 * Package: BaoziThread
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/29 - 18:59
 */
public class test {
    public static void main(String[] args) {
        Baozi bz = new Baozi();
        new BaoziPu(bz).start();
        new ChiHuo(bz).start();
    }
}
