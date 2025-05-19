/**
 * ClassName: Person
 * Package: PACKAGE_NAME
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/14 - 8:17
 */
public class Person {
    String name;
    private int age;
    private String email;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return name+"\t"+age+"\t"+email;
    }

    public Person() {
        System.out.println("无参数构造");
    }
//全参构造，对于prvite参数不安全
//    public Person(String name, int age, String email) {
//        this.name = name;
//        this.age = age;
//        this.email = email;
//    }


    //单参构造方法，对于私有属性只能用set方法设置
    public Person(String name) {
        this.name = name;
    }
}
