package cn.cx;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * ClassName: MainMenu
 * Package: cn.cx
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/15 - 15:03
 */
public class MainMenu {
    //存储数据
    static List<Bills> billsList = new ArrayList<>();
    //类加载时会第一时间执行，把数据加入到billsList
    static {
        billsList.add(new Bills("吃饭支出","交行","支出",247,"2021-03-02","家庭聚餐"));
        billsList.add(new Bills("吃饭支出","交行","支出",247,"2021-03-05","朋友聚餐"));
        billsList.add(new Bills("工资收入","现金","收入",5000,"2021-04-01","发工资了"));
        billsList.add(new Bills("服装支出","交行","支出",654,"2021-05-05","买衣服"));
        billsList.add(new Bills("吃饭支出","现金","支出",465,"2021-05-02","海底捞"));
        billsList.add(new Bills("股票收入","交行","收入",8000,"2021-05-01","A股大涨！"));
        billsList.add(new Bills("股票收入","交行","收入",6000,"2021-05-22","B股也涨！"));
        billsList.add(new Bills("工资收入","现金","收入",5500,"2022-03-12","发工资"));
        billsList.add(new Bills("礼金支出","现金","支出",300,"2022-04-05","狗哥结婚"));
        billsList.add(new Bills("其他支出","交行","支出",560,"2022-05-17","去重庆玩"));
        billsList.add(new Bills("交通支出","交行","支出",200,"2022-03-05","回来坐高铁"));
        billsList.add(new Bills("工资收入","现金","收入",5600,"2022-01-02","发工资"));
    }
    public static void main(String[] args) {
        run();
    }
    public static void showMenu(){
        System.out.println("-----------随手记-----------");
        System.out.println("1.添加账务  2.删除账务  3.查询账务  4.退出系统");
        System.out.println("请输入功能序号「1-4」：");
    }
    public static void run(){
        showMenu();
        //创建扫描器
        Scanner scanner = new Scanner(System.in);
        while (true){
            int num = scanner.nextInt();
            switch (num){
                case 1:
                    addBills();
                    break;
                case 2:
                    delBills();
                    break;
                case 3:
                    select();
                    break;
                case 4:
                    System.out.println("系统已退出！👋");
                    return;
                default:
                    System.out.println("请重新输入！");
            }
        }
    }

    private static void delBills() {
        //创建扫描器
        Scanner scanner = new Scanner(System.in);
        System.out.println("随手记>>账务删除");

        //显示所有账务
        selectAll();
        System.out.println("请输入ID来删除对应账务：");
        int id = scanner.nextInt();
        billsList.remove(id-1);
        System.out.println("账务删除成功！");
        showMenu();
    }

    private static void addBills() {
        //创建扫描器
        Scanner inScanner = new Scanner(System.in);
        //创建Bills对象并实例化
        Bills bills = new Bills();
        //根据对象添加对应属性
        System.out.println("请输入类别：");
        bills.setName(inScanner.next());
        System.out.println("请输入账户：");
        bills.setAccount(inScanner.next());
        System.out.println("请输入支出收入类型：");
        bills.setType(inScanner.next());
        System.out.println("请输入金额：");
        bills.setTotal(inScanner.nextDouble());
        System.out.println("请输入时间：");
        bills.setTime(inScanner.next());
        System.out.println("请输入备注：");
        bills.setDesc(inScanner.next());

        billsList.add(bills);
        System.out.println("添加账务成功！");
        showMenu();
    }

    /**
     * 查询方法：1.查询所有 2.按时间查询 3.按收入支出类型查询 ......
     */
    private static void select() {
        System.out.println("随手记>>账务查询");
        System.out.println("1.查询所有 2.按时间查询 3.按收入支出类型查询 0.返回上一级");
        System.out.println("请输入功能序号「0-3」：");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        switch (num){
            case 1:
                selectAll();
                break;
            case 2:
                selectByTime();
                break;
            case 3:
                selectByType();
                break;
            case 0:
                return;
            default:
                System.out.println("请重新输入！");
                break;
        }
        showMenu();
    }

    private static void selectAll() {
        print(billsList);
    }

    private static void selectByTime() {
        //创建时间格式化对象
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("随手记>>账务查询>>时间段查询");
        //创建扫描器
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入：开始时间");
        String start = scanner.next();
        System.out.println("输入：结束时间");
        String end =scanner.next();
        //利用stream流进行筛选
        List<Bills> billsListByTime = billsList.stream()
                .filter(bills -> {
                    String time = bills.getTime();
                    try {
                        //将字符串解析成具体时间
                        Date startDate = format.parse(start);
                        Date endDate = format.parse(end);
                        Date timeDate = format.parse(time);
                        //判断是否在时间区间内
                        if(timeDate.after(startDate) && timeDate.before(endDate))
                            return true;
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    return false;
                }).collect(Collectors.toList());
        print(billsListByTime);
    }

    private static void selectByType() {
        System.out.println("随手记>>账务查询>>收入或支出类型查询");
        System.out.println("输入「收入|支出」");
        //创建扫描器
        Scanner scanner = new Scanner(System.in);
        String type = scanner.next();
        //利用stream流进行筛选
        List<Bills> billsListByType = billsList.stream()
                .filter(bills -> {
                    String type1 = bills.getType();
                    return type1.equals(type);
                }).collect(Collectors.toList());
        print(billsListByType);
    }
    public static void print(List<Bills> billsList){
        int i = 1;
        System.out.println("ID\t\t类别\t\t\t类型\t\t账户\t\t金额\t\t\t时间\t\t\t\t备注");
        for (Bills bills : billsList) {
            System.out.println(i + "\t\t" + bills.getName() + "\t\t" + bills.getType() + "\t\t" +
                    bills.getAccount()+"\t\t" + bills.getTotal() + "\t\t" + bills.getTime() +
                    "\t\t" + bills.getDesc());
            i += 1;
        }
    }
}
