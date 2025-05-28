import java.io.*;

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
