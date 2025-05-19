/**
 * ClassName: classtest1
 * Package: PACKAGE_NAME
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/13 - 14:35
 */
public class classTest1 {
    public static void main(String[] args) {
/*        int[] array = {10,20,30,40,50};
        for (int i = 0; i <array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("==============");

        for(int min=0,max=array.length-1;min<max;min++,max--){
            int temp = array[min];
            array[min] = array[max];
            array[max] = temp;
        }

        for(int i :array){
            System.out.println(i);
        }*/

        //创建集合储存person信息
 /*       List<Person> personList = new ArrayList<>();
        Person person = new Person("Peter");
        person.setAge(20);
        person.setEmail("123456@126.com");
        //将创建对象加入到集合储存
        personList.add(person);*/

        //查找字符串中是否存在某个字符
/*
        String str="abdccffgs";
        if(str.indexOf("bdc") != -1){
            System.out.println("存在");
        }else {
            System.out.println("不存在");
        }

        //过滤字符,注意：字符串一旦创建，不会改变
        String s = "你大爷，hello";
        String m = "你大爷";
        if (s.contains(m)){
            //replace方法返回的是一个新字符串
            String snew = s.replace(m,"*");
            System.out.println(snew);
        }else {
            System.out.println(s);
        }*/

        /*Animal dog = new Dog();
        dog.sound();

        if(dog instanceof Dog){
            Dog dog1 = (Dog) dog;
            dog1.wagTail();
        }*/

    }

    static class Animal {
        public void sound() {
            System.out.println("动物发出声音");
        }
    }

    static class Dog extends Animal {
        @Override
        public void sound() {
            System.out.println("狗汪汪叫");
        }

        // 子类特有方法
        public void wagTail() {
            System.out.println("狗摇尾巴");
        }
    }
}
