/**
 * ClassName: TalkPackage
 * Package: PACKAGE_NAME
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/20 - 16:04
 */
public class TalkPackage extends ServicePackage implements CallService,SendService,NetService{
    private int talkTime;
    private int smsCount;

    public TalkPackage(){
        super(58);
        this.talkTime=500;
        this.smsCount=30;
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
        int temp=1;
        while (temp++ <= flow){
            if(card.getMoney() >=2){
                card.setRealFlow(card.getRealFlow()+1);
                card.setConsumAmount(card.getConsumAmount()+2);
                card.setMoney(card.getMoney()-2);
            }else break;

        }
    }

    @Override
    public String toString() {
        return
                "通话时长=" + talkTime +"小时"+
                        "\t短信条数=" + smsCount +"条"+
                        "\t上网流量=" + 0 +"GB"+
                        "\n资费"+getPrice()

                ;
    }
}
