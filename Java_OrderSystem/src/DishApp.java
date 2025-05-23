import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: Dishapp
 * Package: PACKAGE_NAME
 * Dscription:frame of Dish
 *
 * @Author: gw
 * @Creat: 2025/5/13 - 21:59
 */
public class DishApp {
    //提前准备菜品展示给用户，同时用户可以点菜
    //定义集合，储存菜品
    static List<Dish> dishList = new ArrayList<>();
    static List<Dish> personDish = new ArrayList<>();
    List<Integer> dishCount = new ArrayList<>();
    public static void main(String[] args) {
        //初始化菜品
        initDish();
        //创建扫描器对象，获取控制台输入内容
        Scanner s = new Scanner(System.in);

        while (true){
            //展示菜单
            showMenu();
            //获取内容 阻塞效果（程序不会再往下执行）
            int num = s.nextInt();
            //判断用户输入的数字
            switch (num){
                case 1:
                    //展示菜单
                    showDishMenu();
                    //处理点菜
                    while (true){
                        //获取控制台输入
                        int id = s.nextInt();
                        //结束switch
                        if(id == 0){
                            break;
                        }

                        //从菜单集合中获得的菜品
                        Dish dish = dishList.get(id - 1);
                        System.out.println("亲，您点了："+dish.name);
                        personDish.add(dish);
                        System.out.println("---输入序号点菜，按0返回上一级---");
                    }
                    System.out.println();
                    break;
                case 2:
                    //展示已点菜品
                    showPersonDish();
                    break;
                case 3:
                    //买单
                    buy();
                    //结束整个循环
                    return;
            }
        }


    }
    /**
     * 展示菜单
     */
    private static void showDishMenu() {
        System.out.println("----请您点菜----");
        for (int i = 0; i < dishList.size(); i++) {
            //从集合获取每一个菜品对象
            Dish dish = dishList.get(i);
            System.out.println(dish);
        }
        System.out.println("---输入序号点菜，空格隔开，按0返回上一级---");
    }
    /**
     * 展示已点菜品方法
     */
    private static void showPersonDish() {
        System.out.println("---已点菜品---");
        for (int i = 0; i < personDish.size(); i++) {
            Dish dish = personDish.get(i);
            System.out.println(dish.name+"\t"+dish.price);
        }
        System.out.println();
    }
    /**
     * 买单方法
     */
    private static void buy() {
        System.out.println("---请稍等，正在结算---");
        //定义总金额
        double total = 0f;
        //遍历已点菜品价格
        for (Dish dish : personDish) {
            total += dish.price;
        }
        System.out.println("您本次共消费："+total+"元");
    }


    public static void showMenu(){
        System.out.println("----主菜单----");
        System.out.println("1\t显示菜单");
        System.out.println("2\t显示已点菜品");
        System.out.println("3\t买单");
        System.out.println("----请根据编号选择服务----");

    }

    /**
     * 初始化菜品方法
     */
    public static void initDish(){
//        Dish dish1 = new Dish(1,"辣椒炒肉",29.0);
//        dishList.add(dish1);
//        Dish dish2 = new Dish(2,"炖王八",59.0)2,"炖王八",59.0;
//        dishList.add(dish2);
//        //存放菜品
//        dishList.add(new Dish(3,"地三鲜",18.0));
//        dishList.add(new Dish(4,"小酥肉",27.0));
//        dishList.add(new Dish(5,"啤酒鸭",38.0));
//        dishList.add(new Dish(6,"酸菜鱼",40.0));
        addDish(1,"辣椒炒肉",29.0);
        addDish(2,"炖王八",59.0);
        addDish(3,"地三鲜",18.0);
        addDish(4,"小酥肉",27.0);
        addDish(5,"啤酒鸭",38.0);
        addDish(6,"酸菜鱼",40.0);
    }

    /**
     * 添加菜品方法
     */
    public static void addDish(int id, String name, double price){
        dishList.add(new Dish(id,name,price));
    }
}
