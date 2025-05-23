/**
 * ClassName: Scene
 * Package: PACKAGE_NAME
 * Dscription:创建不同模拟场景
 *
 * @Author: gw
 * @Creat: 2025/5/21 - 19:54
 */
public class Scene {
    private String desc;//场景描述
    private  int number;//花费数量（通话时长，短信数量，流量：G）

    public Scene(String desc, int number) {
        this.desc = desc;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Scene{" +
                "desc='" + desc + '\'' +
                ", number=" + number +
                '}';
    }
}
