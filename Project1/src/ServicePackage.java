/**
 * ClassName: ServicePackage
 * Package: PACKAGE_NAME
 * Dscription:每个套餐父类
 *
 * @Author: gw
 * @Creat: 2025/5/20 - 14:07
 */
public abstract class ServicePackage {
    private int price;

    public ServicePackage(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ServicePackage{" +
                "price=" + price +
                '}';
    }
}
