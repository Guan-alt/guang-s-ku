package reflectTest;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Properties;

/**
 * ClassName: reflectDemo
 * Package: reflectTest
 * Dscription:用反射机制，在不修改原文件代码的情况下创建实例对象，调用对应方法
 *
 * @Author: gw
 * @Creat: 2025/5/22 - 16:50
 */
public class reflectDemo {
    public static void main(String[] args) throws Exception{
        //Properties类通常用于处理配置文件,是一个集合，元素是键值对应的
        Properties pro = new Properties();
        /*ClassLoader（类加载器)是 JVM 的核心组件之一，
         负责将类的字节码（.class 文件）动态加载到内存中，并生成对应的 Class 对象*/

        //创建类加载器对象，getClass().getClassLoader() 方法用于获取当前类的类加载器
        ClassLoader loader = reflectDemo.class.getClassLoader();

        //创建输入流，获得和pro.properties文件的操作权限，并将配置文件通过类加载器对象加载到输入流，
        InputStream is = loader.getResourceAsStream("pro.properties");
        //通过输入流，把输入流已经加载的配置文件输入到集合里
        pro.load(is);
        //获取到集合里对应的类名和方法名
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");
        System.out.println(className);

        /**
         * 第一行使用Class.forName方法根据类名动态加载类，返回一个Class对象。
         * 第二行调用该Class对象的newInstance方法创建实例。
         */
        //动态加加载，根据类的全限定名，在运行时加载类到 JVM 中。
        Class<?> cls = Class.forName(className);
        //这时类被加载进jvm中了，可以用类对象去创建实例，这里用的是类对象的无参构造方法
        //如果用有参构造方法还要再获取有参构造方法再使用
        Object obj = cls.newInstance();


        //根据类对象获取对于的方法，类名+类的参数类型.class
        Method method1 = cls.getDeclaredMethod(methodName,double.class);
        //如果获取的方法是private修饰的，需要暴力反射，不然没有权限调用
//        method1.setAccessible(true);
        //invoke方法是根据创建的实例来调用这个方法
        method1.invoke(obj,65.0);

        System.out.println(obj.toString());




    }
}
