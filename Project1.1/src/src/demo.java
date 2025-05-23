package src;

import java.util.Map;

/**
 * ClassName: demo
 * Package: PACKAGE_NAME
 * Dscription:场景测试
 *
 * @Author: gw
 * @Creat: 2025/5/21 - 20:13
 */
public class demo {
    public static void main(String[] args) {
        //选择超人套餐
        SuperPackage superPackage = new SuperPackage();
        //新建电话卡
        MobileCard mobileCard = new MobileCard("155446641", superPackage, 1000);
        //获取一个随机模拟场景
        Map<String, Scene> sciences = new Mock().getScience();

        //遍历模拟场景，测试需求
        for (Map.Entry<String, Scene> entry : sciences.entrySet()) {
            Scene scene = entry.getValue();
            System.out.println(scene.toString());
            switch (entry.getKey()) {
                case "call":
                    mobileCard.call(scene.getNumber());
                    break;
                case "send":
                    mobileCard.send(scene.getNumber());
                    break;
                case "net":
                    mobileCard.net(scene.getNumber());
            }
        }
        mobileCard.show();
    }
}
