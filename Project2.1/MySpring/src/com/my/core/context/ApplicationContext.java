package com.my.core.context;

import com.my.annotation.AutoDi;
import com.my.annotation.Instance;
import com.my.core.BeanFactory;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * ClassName: ApplicationContext
 * Package: com.my.core.context
 * Dscription:核心代码
 * 容器是创建对象和管理对象的地方，程序从容器中获取对象。
 * 获取对象的方法是基于反射机制，根据对象名得到对象。
 * 容器是基于工厂方法设计的，通过工厂创建对象。
 *
 * 在容器中取对象首先要扫描对象类的路径，所以在创建ApplicationContext容器时需要指定类的扫描路径，即包的扫描规则。
 * 一个创建好的对象我们称之为BeanDefinition对象, BeanDefinition对象保存到一个Map集合里面。在容器中获取对象就是在Map集合里面里取得对象。
 *
 * @Author: gw
 * @Creat: 2025/6/3 - 11:34
 */
public class ApplicationContext implements BeanFactory {
    // 定义一个BeanDefinition对象集合
    Map<String, Object> definitions = new HashMap();

    /**
     * 实现方法
     * @param beanName 对象名
     * @return
     */
    @Override
    public Object getBean(String beanName) {
        return definitions.get(beanName);
    }

    /**
     * 构造方法
     * @param basePackage 加载类需要扫描的包
     */
    public ApplicationContext(String basePackage){
        // 包摸摸规则
        File basePackagePath = getBeanPackagePath(basePackage);
        // 实例化并注册对象
        classLoader(basePackagePath);
        // 依赖注入
        injection();
    }

    /*① 包扫描规则阶段
    包扫描规则就是把包名转换成路径，并且得到包的真实路径（绝对路径）。*/
    /**
     * 获取类的根目录
     * @return
     */
    private String getRootPath(){
        // 得类的根目录
        URL url = Thread.currentThread().getContextClassLoader().getResource("");
//        System.out.println(url.getPath());
        return url.getPath();
    }

    /**
     * 把包转换成绝对路径
     * @param basePackage
     * @return
     */
    private File getBeanPackagePath(String basePackage)  {
        // 将包的.替换成 /
//        System.out.println(basePackage);
        String basePackagePath = basePackage.replaceAll("\\.", "/");
//        System.out.println(basePackagePath);
        // 得到绝对路径
        String pathName = getRootPath() + basePackagePath;
//        System.out.println(pathName);
        File path = new File(pathName);
        return path;
    }

//    ② 实例化并注册对象阶段
//    递归扫描包目录下所有文件及子目录，如果是子文件夹，继续扫描（递归），否则加载类。如果类有@Instance注解，实例化对象并注册到definitions集合。
    /**
     * 加载路径下所有类
     * @param path 加载的类路径
     */
    private void classLoader(File path) {
        // 获取路径下的所有内容
        File[] items = path.listFiles();
//        for (File item : items) {
//            System.out.println(item);
//        }
        //如果内容为空，返回。否则,遍历文件夹下所有内容
        if (items == null || items.length == 0) {
            return;
        }
        // 遍历文件夹下所有内容
        for (File item : items) {
            // 如果是文件夹，递归，否则加载类
            if (item.isDirectory()) {
                classLoader(item);// 递归
            } else {
                // 定义类
                classDefine(item);
            }
        }
    }

    /**
     * 定义类
     * （1）加载类
     * （2）实例化类
     * （3）注册类
     * @param file 类文件
     */
    private void classDefine(File file) {
        // 获取类的全名路径,file.getAbsoluteFile()的得到的是file类型，可以后面加toString方法转换为String类型
        String fullName = file.getAbsolutePath().substring(getRootPath().length() - 1);
        // 判断是否为class文件
        if (fullName.contains(".class")) {
            // 将 / 替换成 . , .class 替换成""
            fullName = fullName.replaceAll("\\\\", "\\.")
                    .replace(".class", "");
            // 得到类名，并将首字母转换成小写，即对象名
            String beanName = fullName.substring(fullName.lastIndexOf(".") + 1);
//            System.out.println(beanName);
            beanName = beanName.substring(0, 1).toLowerCase() + beanName.substring(1);
//            System.out.println(beanName);
            try {
                // 类加载
                Class clazz = Class.forName(fullName);
                // 实例化类
                Object object = doCreateBean(beanName, clazz);
                // 注册类
                if (object != null){
                    definitions.put(beanName,object);
                    for (Map.Entry<String, Object> entry : definitions.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        System.out.println("Key: " + key + ", Value: " + value);
                    }
                }

            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * 创建对象
     * @param beanName 对象名
     * @param clazz  类
     * @return
     */
    private Object doCreateBean(String beanName,Class<?> clazz){
        // 是否有注解
        Instance annotation = clazz.getAnnotation(Instance.class);
        // 如果有注解，并且definitions集合中没有该对象，创建对象（单例）
        if(annotation != null && !definitions.containsKey(beanName)){
            // 实例化对象
            try {
                Object object = clazz.getDeclaredConstructor().newInstance();
                return object;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    //        ③ 依赖注入阶段
//        遍历definitions集合中的所有对象，获取对象的类。然后遍历类的所有属性，如果有@AutoDi注解，创建依赖关系。
    /**
     * 依赖注入
     */
    private void injection(){
        // 遍历definitions集合
        for(String beanName : definitions.keySet()){
            // 得到对象
            Object object = definitions.get(beanName);
            // 得到对象的类
            Class clazz = object.getClass();
            // 获取类对象的所有属性
            Field[] declaredFields = clazz.getDeclaredFields();
            // 遍历属性
            for(Field field : declaredFields){
                // 如果属性有注解，注入依赖
                AutoDi autoDi = field.getAnnotation(AutoDi.class);
                if(autoDi != null){
                    try {
                        field.setAccessible(true);// 放开权限
                        // 取得属性名
                        String fieldName = field.getName();
                        // 判断属性类型：如果是接口，在属性名后加Impl
                        if(field.getType().isInterface()){
                            fieldName = fieldName + "Impl";
                        }
                        // 设置值:从definitions集合取值
                        field.set(object,definitions.get(fieldName));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
