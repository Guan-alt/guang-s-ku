package reflectTest;

/**
 * ClassName: book
 * Package: reflectTest
 * Dscription:目标测试类
 *
 * @Author: gw
 * @Creat: 2025/5/22 - 17:06
 */
public class Book {
    public String name = "西游记";
    private double price ;

    public Book() {
    }

    public Book(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private void look(){
        System.out.println("看"+name);
    }

    @Override
    public String toString() {
        return "book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

