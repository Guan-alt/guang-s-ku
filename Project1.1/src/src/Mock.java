package src;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: Mock
 * Package: PACKAGE_NAME
 * Dscription:（2）用于预定义多个场景，
 * 并将多个场景分类（call,send,net）存储在Map中：Map<String,List<Scene> sceneMap
 *
 * @Author: gw
 * @Creat: 2025/5/21 - 19:57
 */
public class Mock {
    //每个类别预定多个场景（call:模拟打电话，net：模拟上网，send:模拟发信息）
    //string为场景，list为具体场景动作集合
    static Map<String, List<Scene>> sceneMap = new LinkedHashMap<>();

    static {
        //打电话场景动作集
        List<Scene> callSciences = List.of(
                new Scene("通话场景1", 30),
                new Scene("通话场景2", 60),
                new Scene("通话场景3", 100),
                new Scene("通话场景4", 200)
        );

        //发短信场景动作集
        List<Scene> smsSciences = List.of(
                new Scene("短信场景1", 10),
                new Scene("短信场景2", 100),
                new Scene("短信场景3", 200)
        );

        //上网场景动作集
        List<Scene> netSciences = List.of(
                new Scene("上网场景1", 3),
                new Scene("上网场景2", 6),
                new Scene("上网场景3", 20)
        );

        //将动作集放入哈希图
        sceneMap.put("call", callSciences);
        sceneMap.put("send", smsSciences);
        sceneMap.put("net", netSciences);
    }

    public Map<String, Scene> getScience() {
        Map<String, Scene> sciences = new LinkedHashMap<>();
        //遍历每个动作集
        for (Map.Entry<String, List<Scene>> entry : sceneMap.entrySet()) {
            //随机获取该动作集的场景编号
            int i = (int) (Math.random() * 10) % entry.getValue().size();
            //将该具体动作放入哈希图
            sciences.put(entry.getKey(), entry.getValue().get(i));
        }
        return sciences;
    }
}
