/**
 * ClassName: SuperPackage
 * Package: Interface
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/20 - 14:34
 */
public class SuperPackage extends ServicePackage implements CallService, NetService, SendService {
    private int talkTime;
    private int smsCount;
    private int flow;

    public SuperPackage() {
        super(78);
        this.talkTime=200;
        this.smsCount=50;
        this.flow=5;
    }


    @Override
    public String toString() {
        return
                "通话时长=" + talkTime +"小时"+
                "\t短信条数=" + smsCount +"条"+
                "\t上网流量=" + flow +"GB"+
                        "\n资费"+getPrice()

                ;
    }

    @Override
    public void call(int time, MobileCard card) {
        int temp = 1;
        while (temp++ <= time){
            if(talkTime - card.getRealTalkTime() >= 1){
                card.setRealTalkTime(card.getRealTalkTime()+1);
            }else if(card.getMoney() >= 0.2){
                card.setRealTalkTime(card.getRealTalkTime()+1);
                card.setConsumAmount(card.getConsumAmount()+0.2);
                card.setMoney(card.getMoney()-0.2);
            }else break;
        }
    }
    @Override
    public void send(int count,MobileCard card){
        int temp = 1;
        while (temp++ <= count){
            if(smsCount-card.getRealSMScount() >= 1){
                card.setRealSMScount(card.getRealSMScount()+1);
            }else if(card.getMoney() >= 0.1){
                card.setRealSMScount(card.getRealSMScount()+1);
                card.setConsumAmount(card.getConsumAmount()+0.1);
                card.setMoney(card.getMoney()-0.1);
            }else break;
        }
    }
    @Override
    public void net(int flow, MobileCard card) {
        int temp = 1;
        while (temp++ <= flow) {
            if (this.flow*1024 - card.getRealFlow() >= 1) {
                card.setRealFlow(card.getRealFlow() + 1);
            } else if(card.getMoney()>=1.1){
                card.setRealFlow(card.getRealFlow() + 1);
                card.setConsumAmount(card.getConsumAmount() + 1);
                card.setMoney(card.getMoney() - 1);
            }else break;
        }
    }
}
