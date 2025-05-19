/**
 * ClassName: Dish
 * Package: PACKAGE_NAME
 * Dscription:菜品类
 *
 * @Author: gw
 * @Creat: 2025/5/13 - 21:52
 */
public class Dish {
//    编号
    int id;
//    菜品
    String name;
//    价格
    Double price;
    //生成构造器alt+(fn)+insert

    public Dish(int id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return  id+"\t"+name+"\t"+price;
    }
}
