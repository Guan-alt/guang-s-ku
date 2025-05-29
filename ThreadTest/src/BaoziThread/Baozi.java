package BaoziThread;

/**
 * ClassName: Baozi
 * Package: BaoziThread
 * Dscription:包子类
 *
 * @Author: gw
 * @Creat: 2025/5/29 - 9:27
 */
public class Baozi {
    private String Baozip;//包子皮
    private String Baozix;//包子馅
    private boolean isFlag;//包子状态（是否有包子）

    public String getBaozip() {
        return Baozip;
    }

    public void setBaozip(String baozip) {
        Baozip = baozip;
    }

    public String getBaozix() {
        return Baozix;
    }

    public void setBaozix(String baozix) {
        Baozix = baozix;
    }

    public boolean isFlag() {
        return isFlag;
    }

    public void setFlag(boolean flag) {
        isFlag = flag;
    }
}
