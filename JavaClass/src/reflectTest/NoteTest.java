package reflectTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ClassName: NoteTest
 * Package: reflectTest
 * Dscription:和reflectDemo作用类似，都是利用反射机制，在不修改原文件代码的情况下创建实例对象，调用对应方法
 *
 * @Author: gw
 * @Creat: 2025/5/23 - 9:39
 */
@NoteDemo(className = "reflectTest.Book", methodName = {"setPrice","look"})//methodName是一个字符串集合，只有一个值时可以省略{}
public class NoteTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //获取当前文件字节码文件
        Class<NoteTest> cls = NoteTest.class;
        //从类 cls 的元数据中查找 NoteDemo 注解，并返回其实例。
        /**
         * 等价于NoteDemo为接口，其子类实现的接口方法，并返回了对应方法的值
         * 这里就是返回了键对值，reflectTest.Book，setPrice
         */
        //根据当前字节码文件，获取对于的注解对象
        NoteDemo note = cls.getAnnotation(NoteDemo.class);
        //根据键获取值
        String className = note.className();
        String[] methodName = note.methodName();
//        System.out.println(className);
//        System.out.println(methodName[0]);

        //动态加加载，根据类的全限定名，在运行时加载类到 JVM 中。
        /**
         * 方法                   	行为                      适用场景
         * Class.forName(className)	加载类并触发静态初始化	    数据库驱动、框架初始化
         * Class.forName(className, false, loader)	        加载类但不触发静态初始化	避免副作用的动态加载
         * ClassLoader.loadClass()	仅加载类（不触发静态初始化）	需要控制初始化的延迟加载
         * 何时传入具体的 loader？
         * 当类不在默认类路径中时（如动态加载外部插件、网络资源等），需传入自定义的 ClassLoader。
         * 需要隔离类的加载环境时（如 Tomcat 的 Web 应用隔离）。
         * 何时传入 null？
         * 类位于默认类路径中，且无需特殊加载逻辑时，可直接传入 null。
         * 类加载器的传递规则
         * 如果未显式指定 loader，则使用当前线程的上下文类加载器（Thread.currentThread().getContextClassLoader()）。
         * 如果传入 null，则使用系统类加载器（ClassLoader.getSystemClassLoader()）。
         */
        Class<?> cl = Class.forName(className);
        //这时类被加载进jvm中了，可以用类对象去创建实例，这里用的是类对象的无参构造方法创建对象实例
        //若要通过反射调用有参构造方法创建对象实例，
        //需使用 getDeclaredConstructor() 方法获取指定参数类型的构造方法，再调用 newInstance() 传入参数
        Constructor<?> constructorOfName = cl.getDeclaredConstructor(String.class);
        Object bj = constructorOfName.newInstance("红楼梦");
        System.out.println(bj.toString());
//        Object bj = cl.newInstance();

        //根据类对象获取对于的方法，类名+类的参数类型.class
        Method method1 = cl.getDeclaredMethod(methodName[0],double.class);
        Method method2 = cl.getDeclaredMethod(methodName[1]);

        //如果获取的方法是private修饰的，需要暴力反射，不然没有权限调用
        method2.setAccessible(true);
//        method1.setAccessible(true);
        //invoke方法是根据创建的实例来调用这个方法
//        System.out.println(method1);
        //使用方法是，参数类型一定要匹配，不匹配会抛出IllegalArgumentException: argument type mismatch,即类型不匹配
        method1.invoke(bj,78.0);
        method2.invoke(bj);

        System.out.println(bj.toString());
    }
}

