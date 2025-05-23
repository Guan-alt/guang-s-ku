/**
 * ClassName: test
 * Package: PACKAGE_NAME
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/20 - 16:12
 */
public class test {
    public static void main(String[] args) {
        //选择超人套餐
        SuperPackage superPackage = new SuperPackage();
        //创建一张使用超人套餐的新电话卡，并存一百
        MobileCard card1 = new MobileCard("17679409044",superPackage,100);
        /**
         * （1）过年群发祝福短信100条。
         * （2）与女朋友通话30分钟。
         * （3）打游戏用了100G流量。
         */
//        card1.send(100);
//        card1.call(30);
//        card1.net(100*1024);
//        card1.show();

        System.out.println("=========分割线===================================================");
        //选择网虫套餐
        MobileCard card2 = new MobileCard("17679409044",new NetPackage(),100);
        card2.send(100);
        card2.call(30);
        card2.net(100*1024);
        card2.show();

        System.out.println("=========分割线===================================================");
//        //选择话痨套餐
//        MobileCard card3 = new MobileCard("17679409044",new TalkPackage(),100);
//        card3.send(100);
//        card3.call(30);
//        card3.net(100*1024);
//        card3.show();

    }
}
