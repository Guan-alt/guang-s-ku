import java.util.HashSet;

/**
 * ClassName: test
 * Package: PACKAGE_NAME
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/20 - 10:49
 */
public class test {
    public static void main(String[] args) {
        HashSet<Person> set = new HashSet<>();
        Person p1 = new Person("Alice", 25);
        Person p2 = new Person("Alice", 25);
        Person p3 = new Person("Alice", 18);
        Person p4 = new Person("Peter", 18);
        Person p5 = new Person("Peter", 20);
        Student p6 = new Student("Alice", 25);

        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        set.add(p5);


//        System.out.println(p1.hashCode());
//        System.out.println(p2.hashCode());
//        System.out.println(p3.hashCode());
//        System.out.println(p4.hashCode());
//        System.out.println(p5.hashCode());
//        System.out.println(p6.hashCode());

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
        System.out.println(p6);


        System.out.println(set.size());
    }
}
