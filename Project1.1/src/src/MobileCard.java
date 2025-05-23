package src;

/**
 * ClassName: MobileCard
 * Package: PACKAGE_NAME
 * Dscription:卡的模版类，定义卡的属性和功能
 *
 * @Author: gw
 * @Creat: 2025/5/20 - 14:17
 */
public class MobileCard {
    private String cardNumber;//卡号
    private ServicePackage servicePackage;//套餐
    private double money;//余额
    private double consumeAmount;//实际消费金额
    private int realTalkTime;//实际通话时长
    private int realSMScout;//实际发短信条数
    private int realFlow;//实际使用流量
    int overCallTime;//超出套餐的通话时间
    int overSendCount;//超出套餐的短信条数
    int overUseFlow;//超出套餐的流量

    /**
     * @param cardNumber：卡号
     * @param servicePackage：套餐
     * @param money：话费
     */
    public MobileCard(String cardNumber, ServicePackage servicePackage, double money) {
        super();
        this.cardNumber = cardNumber;
        this.servicePackage = servicePackage;
        this.money = money;
    }


    public void show() {

        System.out.println("卡号：" + cardNumber + "\t余额：" + String.format("%.2f",money) + "元" + "\t总消费金额：" + String.format("%.2f",consumeAmount) + "元");
        System.out.println("实际通话时间：" + realTalkTime + "小时" + "\t实际发送短信：" + realSMScout + "条" + "\t实际使用流量：" + realFlow + "G");
        System.out.println("通话消费:" + overCallTime * servicePackage.getCallPrice() + "元" + "\t短信消费：" + overSendCount* servicePackage.getSendPrice() + "元" + "\t流量消费：" + overUseFlow * servicePackage.getNetPrice() + "元");
//        System.out.println("实际使用流量："+realFlow+"M"+"="+realFlow/1024+"G");
        System.out.println("===========套餐==========");
        System.out.println(servicePackage.toString());

    }

    public void call(int time) {
        double callPrice = servicePackage.getCallPrice();
        //判断套餐是否有该服务，有则使用套餐的通话服务，没有则使用该套餐的服务价格进行消费计算
        if (servicePackage instanceof CallService) {
            //强转使用套餐的通话服务
            CallService callService = (CallService) servicePackage;
            overCallTime =callService.call(time, this);
            int overTime = overCallTime;

            if (overTime > 0) System.out.println("接下来使用套餐外的通话服务,超出通话时间为：" + overTime + "分钟");
            //判断套餐的通话时长是否用尽，用尽了则使用该套餐的服务价格进行消费计算
            while (overTime-- > 0) {
                if (this.getMoney() >= callPrice) {
                    this.setRealTalkTime(this.getRealTalkTime() + 1);
                    this.setConsumeAmount(this.getConsumeAmount() + callPrice);
                    this.setMoney(this.getMoney() - callPrice);
                } else break;
            }
        } else {
            System.out.println("使用套餐外的通话服务");
            while (time-- > 0) {
                if (this.getMoney() >= callPrice) {
                    this.setRealTalkTime(this.getRealTalkTime() + 1);
                    this.setConsumeAmount(this.getConsumeAmount() + callPrice);
                    this.setMoney(this.getMoney() - callPrice);
                } else break;
            }
        }
    }

    public void send(int count) {
        double sendPrice = servicePackage.getSendPrice();
        //判断套餐是否有该服务，有则使用套餐的短信服务，没有则使用该套餐的服务价格进行消费计算
        if (servicePackage instanceof SendService) {
            //强转使用套餐的短信服务
            SendService sendService = (SendService) servicePackage;
            overSendCount = sendService.send(count, this);
            int overCount = overSendCount;
            if (overCount > 0) System.out.println("接下来使用套餐外的短信服务,超出的短信条数为："+overCount+"条");
            //判断套餐的免费短信是否用尽，用尽了则使用该套餐的服务价格进行消费计算
            while (overCount-- > 0) {
                if (this.getMoney() >= sendPrice) {
                    this.setRealSMScout(this.getRealSMScout() + 1);
                    this.setConsumeAmount(this.getConsumeAmount() + sendPrice);
                    this.setMoney(this.getMoney() - sendPrice);
                } else break;
            }

        } else {
            System.out.println("使用套餐外的短信服务");
            while (count-- > 0) {
                if (this.getMoney() >= sendPrice) {
                    this.setRealSMScout(this.getRealSMScout() + 1);
                    this.setConsumeAmount(this.getConsumeAmount() + sendPrice);
                    this.setMoney(this.getMoney() - sendPrice);
                } else break;
            }
        }
    }

    public void net(int flow) {
//        flow *= 1024;
        double netPrice = servicePackage.getNetPrice();
        //判断套餐是否有网络服务，有则使用套餐的网络服务，没有则使用该套餐的服务价格进行消费计算
        if (servicePackage instanceof NetService) {
            //强转使用套餐的网络服务
            NetService netService = (NetService) servicePackage;
            overUseFlow = netService.net(flow, this);
            int overFlow = overUseFlow;
            if (overFlow > 0) System.out.println("接下来使用套餐外的网络服务,超出套餐流量为：" + overFlow + "G");
            //判断套餐的流量是否用尽，用尽了则使用该套餐的服务价格进行消费计算
            while (overFlow-- > 0) {
                if (this.getMoney() >= netPrice) {
                    this.setRealFlow(this.getRealFlow() + 1);
                    this.setConsumeAmount(this.getConsumeAmount() + netPrice);
                    this.setMoney(this.getMoney() - netPrice);
                } else break;
            }

        } else {
            System.out.println("使用套餐外的网络服务");
            while (flow-- > 0) {
                if (this.getMoney() >= netPrice) {
                    this.setRealFlow(this.getRealFlow() + 1);
                    this.setConsumeAmount(this.getConsumeAmount() + netPrice);
                    this.setMoney(this.getMoney() - netPrice);
                } else break;
            }
        }
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public ServicePackage getServicePackage() {
        return servicePackage;
    }

    public void setServicePackage(ServicePackage servicePackage) {
        this.servicePackage = servicePackage;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getConsumeAmount() {
        return consumeAmount;
    }

    public void setConsumeAmount(double consumeAmount) {
        this.consumeAmount = consumeAmount;
    }

    public int getRealTalkTime() {
        return realTalkTime;
    }

    public void setRealTalkTime(int realTalkTime) {
        this.realTalkTime = realTalkTime;
    }

    public int getRealSMScout() {
        return realSMScout;
    }

    public void setRealSMScout(int realSMScout) {
        this.realSMScout = realSMScout;
    }

    public int getRealFlow() {
        return realFlow;
    }

    public void setRealFlow(int realFlow) {
        this.realFlow = realFlow;
    }
}
