package src;

/**
 * ClassName: ServicePackage
 * Package: PACKAGE_NAME
 * Dscription:每个套餐父类，套餐价格，套餐的服务计费内容
 *
 * @Author: gw
 * @Creat: 2025/5/20 - 14:07
 */
public abstract class ServicePackage {
    private int price;//套餐价格
    private double callPrice;//该套餐的通话价格
    private double sendPrice;//改套餐的短信价格
    private double netPrice;//该套餐的流量价格

    public ServicePackage(int price, double callPrice, double sendPrice, double netPrice) {
        this.price = price;
        this.callPrice = callPrice;
        this.sendPrice = sendPrice;
        this.netPrice = netPrice;
    }

    public int getPrice() {
        return price;
    }

    public double getCallPrice() {
        return callPrice;
    }

    public double getSendPrice() {
        return sendPrice;
    }

    public double getNetPrice() {
        return netPrice;
    }

    @Override
    public String toString() {
        return "ServicePackage{" +
                "price=" + price +
                ", callPrice=" + callPrice +
                ", sendPrice=" + sendPrice +
                ", netPrice=" + netPrice +
                '}';
    }
}
