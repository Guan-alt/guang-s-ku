package src;

/**
 * ClassName: NetPackage
 * Package: PACKAGE_NAME
 * Dscription:网虫套餐，有自己的服务价格，套餐内容，套餐服务
 *
 * @Author: gw
 * @Creat: 2025/5/20 - 15:07
 */
public class NetPackage extends ServicePackage implements NetService {

    private int flow;

    public NetPackage() {
        super(68, 0.5, 0.2, 0.5);
        this.flow = 10;
    }

    @Override
    public String toString() {
        return "网虫套餐" +
                "\n{通话时长=" + 0 + "小时" +
                "\t短信条数=" + 0 + "条" +
                "\t上网流量=" + flow + "GB}" +
                "\n{通话价格=" + getCallPrice() + "/分钟" +
                ", 短信价格=" + getSendPrice() + "/条" +
                ", 流量价格=" + getNetPrice() + "/G" +
                '}';
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
