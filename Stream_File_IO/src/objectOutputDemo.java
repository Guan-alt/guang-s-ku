import java.io.*;

/**
 * ClassName: objectOutputDemo
 * Package: PACKAGE_NAME
 * Dscription:对象流用于在Java中序列化对象，实现对象的持久化和网络传输
 *
 * @Author: gw
 * @Creat: 2025/5/21 - 19:15
 */

class Person implements Serializable{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class objectOutputDemo {
    public static void main(String[] args) {
        Person person = new Person("Peter",18);
        try {
            //ObjectOutputStream输入的都是字节流，写入的字节，应该用.dat文件接收，
            // .txt文件也可以接收，但是会出现编码错误，但是可以正常输入正常读取
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Person.dat"));
//            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("PersonDemo.txt"));
            os.writeObject(person);
            os.writeObject(new Person("Alice",20));
            System.out.println("The file has serialized!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
