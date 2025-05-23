package src;

/**
 * ClassName: TalkPackage
 * Package: PACKAGE_NAME
 * Dscription:话痨套餐
 *
 * @Author: gw
 * @Creat: 2025/5/20 - 16:04
 */
public class TalkPackage extends ServicePackage implements CallService, SendService {
    private int talkTime;
    private int smsCount;

    public TalkPackage() {
        super(58, 0.2, 0.1, 2.0);
        this.talkTime = 500;
        this.smsCount = 30;
    }

    @Override
    public String toString() {
        return
                "话痨套餐" +
                        "\n{通话时长=" + talkTime + "小时" +
                        "\t短信条数=" + smsCount + "条" +
                        "\t上网流量=" + 0 + "GB}" +
                        "\n{通话价格=" + getCallPrice() + "/分钟" +
                        ", 短信价格=" + getSendPrice() + "/条" +
                        ", 流量价格=" + getNetPrice() + "/G" +
                        '}';
    }

    public int call(int time, MobileCard card) {
        System.out.println("使用套餐的通话服务");
        while (time-- > 0) {
            if (talkTime - card.getRealTalkTime() >= 1) {
                card.setRealTalkTime(card.getRealTalkTime() + 1);
                if (time == talkTime) System.out.println("该套餐的免费通话时间已用尽！");
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
                if (count == smsCount) System.out.println("该套餐的免费短信条数已用尽！");
            } else {
                return count+1;
            }
        }
        return 0;
    }


}
