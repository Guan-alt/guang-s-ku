/**
 * ClassName: MobileCard
 * Package: PACKAGE_NAME
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/20 - 14:17
 */
public class MobileCard {
    private String cardNumber;//卡号
    private ServicePackage servicePackage;//套餐
    private double money;//余额
    private double consumAmount;//实际费金额
    private int realTalkTime;//实际通话时长
    private int realSMScount;//实际发短信条数
    private int realFlow;//实际使用流量

    /**
     *
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


    public void show(){
        System.out.println("卡号"+cardNumber+"\t余额："+money+"元"+"\t消费金额："+consumAmount);
        System.out.println("实际通话时间"+realTalkTime+"小时"+"\t实际发送短信："+realSMScount+"条"+"\t实际使用流量："+realFlow+"M"+"="+realFlow/1024+"G");
        System.out.println("===========套餐==========");
        System.out.println(servicePackage.toString());

    }

    public void send(int count){
        if(servicePackage instanceof SendService){
            SendService sendService = (SendService) servicePackage;
            sendService.send(count,this);
        }
    }

    public void call(int time){
        if(servicePackage instanceof CallService){
            CallService callService = (CallService) servicePackage;
            callService.call(time,this);
        }
    }

    public void net(int flow){
        if(servicePackage instanceof NetService){
            NetService netService = (NetService) servicePackage;
            netService.net(flow,this);
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

    public double getConsumAmount() {
        return consumAmount;
    }

    public void setConsumAmount(double consumAmount) {
        this.consumAmount = consumAmount;
    }

    public int getRealTalkTime() {
        return realTalkTime;
    }

    public void setRealTalkTime(int realTalkTime) {
        this.realTalkTime = realTalkTime;
    }

    public int getRealSMScount() {
        return realSMScount;
    }

    public void setRealSMScount(int realSMScount) {
        this.realSMScount = realSMScount;
    }

    public int getRealFlow() {
        return realFlow;
    }

    public void setRealFlow(int realFlow) {
        this.realFlow = realFlow;
    }
}
