import java.io.*;
import java.util.ArrayList;

/**
 * ClassName: objectTest
 * Package: PACKAGE_NAME
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/27 - 14:50
 */
public class objectTest {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("Peter", 18));
        list.add(new Person("Tom", 15));
        list.add(new Person("Alice", 28));

        try (ObjectOutputStream ops = new ObjectOutputStream(new FileOutputStream("person2.txt"));){
            ops.writeObject(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person2.txt"));){
            ArrayList<Person> p = (ArrayList<Person>) ois.readObject();
            p.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
