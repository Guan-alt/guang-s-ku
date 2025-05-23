/**
 * ClassName: NetPackage
 * Package: PACKAGE_NAME
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/20 - 15:07
 */
public class NetPackage extends ServicePackage implements NetService{

    private int flow;
    public NetPackage(){
        super(68);
        this.flow = 10;
    }

    public void call(int time, MobileCard card) {
        int temp = 1;
        while (temp++ <= time){
            if(card.getMoney() >= 0.5){
                card.setRealTalkTime(card.getRealTalkTime()+1);
                card.setConsumAmount(card.getConsumAmount()+0.5);
                card.setMoney(card.getMoney()-0.5);
            }else break;
        }
    }

    public void send(int count,MobileCard card){
        int temp = 1;
        while (temp++ <= count){
            if(card.getMoney()>=0.2){
                card.setRealSMScount(card.getRealSMScount()+1);
                card.setConsumAmount(card.getConsumAmount()+0.2);
                card.setMoney(card.getMoney()-0.2);
            }else break;
        }
    }
    @Override
    public void net(int flow, MobileCard card) {
        int temp=1;
        while (temp++ <= flow){
            if(this.flow*1024 - card.getRealFlow() >= 1){
                card.setRealFlow(card.getRealFlow()+1);
            }else if(card.getMoney() >=1){
                card.setRealFlow(card.getRealFlow()+1);
                card.setConsumAmount(card.getConsumAmount()+0.5);
                card.setMoney(card.getMoney()-0.5);
            }else break;
        }
    }


    @Override
    public String toString() {
        return
                "通话时长=" + 0 +"小时"+
                        "\t短信条数=" + 0 +"条"+
                        "\t上网流量=" + flow +"GB"+
                        "\n资费"+getPrice()

                ;
    }
}
