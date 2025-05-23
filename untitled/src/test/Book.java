package test;

import java.time.Period;

/**
 * ClassName: Book
 * Package: test
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/21 - 9:21
 */
public class Book implements Comparable<Book>{
    private String name;
    private double price;

    public Book() {
    }

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    //实现comparable接口，重写compareTo方法，实现自定义排序
    @Override
    public int compareTo(Book o) {
//        //按价格升序排序
//        return Integer.compare((int)this.price,(int)o.price);
        //按价格降序排序
        return Integer.compare((int) o.price,(int) this.price);
    }
}

