package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * ClassName: Comparator_Comparable
 * Package: test
 * Dscription:当自定义类不能比较排序时，实现对自定义类进行排序的两种方法
 *
 * @Author: gw
 * @Creat: 2025/5/21 - 9:20
 */
public class Comparator_Comparable {
    public static void main(String[] args) {
        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(new Book("西游记",50.0));
        bookList.add(new Book("三国演义",47.5));
        bookList.add(new Book("红楼梦",65.0));
        bookList.add(new Book("水浒传",80.0));

//        //1.匿名内部类的方式实现comparator接口，重写比较器compare
//        Collections.sort(bookList, new Comparator<Book>(){
//            @Override
//            public int compare(Book o1, Book o2) {
//                //按价格升序排序
//                return (int)(o1.getPrice() - o2.getPrice());
////                //按价格降序排序
////                return (int)(o2.getPrice() - o1.getPrice());
//            }
//        });
//        System.out.println(bookList);

        //2.book类实现comparable接口，重写compareTo方法
        Collections.sort(bookList);
        System.out.println(bookList);

    }
}
