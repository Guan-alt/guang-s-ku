import java.io.Serializable;

/**
 * ClassName: objectOutputDemo
 * Package: PACKAGE_NAME
 * Dscription:对象流用于在Java中序列化对象，实现对象的持久化和网络传输
 *
 * @Author: gw
 * @Creat: 2025/5/21 - 19:15
 */

class Person implements Serializable {
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
