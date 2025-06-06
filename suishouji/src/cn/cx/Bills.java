package cn.cx;

/**
 * ClassName: Bills
 * Package: cn.cx
 * Dscription:账单抽象类
 *
 * @Author: gw
 * @Creat: 2025/5/15 - 15:20
 */
public class Bills {
    private String name;
    private String account;
    private String type;
    private double total;
    private String time;
    private String desc;


    public Bills() {
    }

    public Bills(String name, String account, String type, double total, String time, String desc) {
        this.name = name;
        this.account = account;
        this.type = type;
        this.total = total;
        this.time = time;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
