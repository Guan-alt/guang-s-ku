import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: demo
 * Package: PACKAGE_NAME
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/21 - 20:13
 */
public class demo {
    public static void main(String[] args) {
        //选择超人套餐
        SuperPackage superPackage = new SuperPackage();
        //新建电话卡
        MobileCard mobileCard  = new MobileCard("15554466641",superPackage,1000);
        //获取一个随机模拟场景
        Map<String,Scene> scences = new Mock().getScence();

        //遍历模拟场景，测试需求
        for (Map.Entry<String, Scene> entry : scences.entrySet()) {
            Scene scene = entry.getValue();
            System.out.println(scene.toString());
            switch (entry.getKey()){
                case "call":
                    mobileCard.call(scene.getNumber());
                    break;
                case "send":
                    mobileCard.send(scene.getNumber());
                    break;
                case "net":
                    mobileCard.net(scene.getNumber()*1024);
            }
        }
        mobileCard.show();
    }
}
