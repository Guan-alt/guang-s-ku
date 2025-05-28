package reflectTest.CheckDemo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ClassName: TestCheck
 * Package: reflectTest.CheckDemo
 * Dscription:模拟测试，对类方法进行测试
 *
 * @Author: gw
 * @Creat: 2025/5/26 - 20:26
 */
public class TestCheck {
    public static void main(String[] args) throws IOException {
        //实例化测试类的对象实例
        Calculator c =new Calculator();
        //根据对象获取类的class文件
        Class<?> cls = c.getClass();
        //根据类对象的class文件获取里面的方法，并存储到数组
        Method[] methods = cls.getMethods();
        int num = 0;
        //创建缓存字符流，用于把异常写进日志文件
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));
        //遍历类对象的方法
        for (Method method : methods) {
            //在遍历的方法中找到有@check标记的方法进行测试
            if(method.isAnnotationPresent(Check.class)){
                try {
                    //根据类对象实例调用方法
                    method.invoke(c);
                } catch (Exception e) {
                    //把出现的异常写入日志文件
                    num++;
                    bw.write(method.getName()+"方法出异常了");
                    bw.newLine();
                    bw.write("异常名称："+e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常的原因："+e.getCause().getMessage());
                    bw.write("=========================");
                    bw.newLine();
                }
            }
        }
        bw.write("本次测试一共出现"+num+"次异常");
        bw.flush();
        bw.close();
    }
}
