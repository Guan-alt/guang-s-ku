import java.io.*;

/**
 * ClassName: objectInputDeom
 * Package: PACKAGE_NAME
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/21 - 19:25
 */
public class objectInputDeom {
    public static void main(String[] args) {
        try {

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("Person.dat"));
//            ObjectInputStream in = new ObjectInputStream(new FileInputStream("PersonDemo.txt"));
//            //每次读一个数据
//            Person person = (Person) in.readObject();
//            Person person1 = (Person) in.readObject();
//            System.out.println(person);
//            System.out.println(person1);
            //readObject读到文件末时，会抛出EOFException异常，进而结束输出流
            while (true){
                Person person = (Person) in.readObject();
                System.out.println(person);
            }
        } catch (EOFException e){
            System.out.println("所有对象都已输出");
        } catch (IOException | ClassNotFoundException e ) {
            throw new RuntimeException(e);
        }
    }
}
