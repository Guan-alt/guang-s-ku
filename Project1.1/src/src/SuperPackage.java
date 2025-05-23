package src;

/**
 * ClassName: SuperPackage
 * Package: Interface
 * Dscription:超人套餐
 *
 * @Author: gw
 * @Creat: 2025/5/20 - 14:34
 */
public class SuperPackage extends ServicePackage implements CallService, NetService, SendService {
    private int talkTime;
    private int smsCount;
    private int flow;

    public SuperPackage() {
        super(78, 0.2, 0.1, 1.0);
        this.talkTime = 200;
        this.smsCount = 50;
        this.flow = 5;
    }

    @Override
    public String toString() {
        return
                "超人套餐" +
                        "\n{通话时长=" + talkTime + "小时" +
                        "\t短信条数=" + smsCount + "条" +
                        "\t上网流量=" + flow + "GB}" +
                        "\n{通话价格=" + getCallPrice() + "/分钟" +
                        ", 短信价格=" + getSendPrice() + "/条" +
                        ", 流量价格=" + getNetPrice() + "/G" +
                        '}';
    }

    @Override
    public int call(int time, MobileCard card) {
        System.out.println("使用套餐的通话服务");
        while (time-- > 0) {
            if (talkTime - card.getRealTalkTime() >= 1) {
                card.setRealTalkTime(card.getRealTalkTime() + 1);
                if (card.getRealTalkTime() == talkTime) System.out.println("该套餐的免费通话时间已用尽！");
            } else {
                return time+1;
            }
        }
        return 0;
    }

    @Override
    public int send(int count, MobileCard card) {
        System.out.println("使用套餐的短信服务");
        while (count-- > 0) {
            if (smsCount - card.getRealSMScout() >= 1) {
                card.setRealSMScout(card.getRealSMScout() + 1);
                if (card.getRealSMScout() == smsCount) System.out.println("该套餐的免费短信条数已用尽！");
            } else {
                return count+1;
            }
        }
        return 0;
    }

    @Override
    public int net(int flow, MobileCard card) {
        System.out.println("使用套餐的网络服务");
        while (flow-- > 0) {
            if (this.flow - card.getRealFlow() >= 1) {
                card.setRealFlow(card.getRealFlow() + 1);
                if (card.getRealFlow() == this.flow) System.out.println("该套餐的免费流量已全部用尽！");
            } else {
                return flow+1;
            }
        }
        return 0;
    }
}
