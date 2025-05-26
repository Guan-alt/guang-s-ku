import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.Set;

/**
 * ClassName: FileWriter
 * Package: PACKAGE_NAME
 * Dscription:对于输入内容要保存为可以被人读取的内容时，用字符流去写，字节流写的保存的是Unicode
 * 注意：用什么写就用什么读，不然可能会读不了
 *
 * @Author: gw
 * @Creat: 2025/5/26 - 16:17
 */
public class FileWriter_FileReader_Test {
    public static void main(String[] args) throws IOException {
       /* FileWriter fw = new FileWriter("a.txt");
        FileReader reader = new FileReader("a.txt");
        //将字符串写入缓冲区
        fw.write("abc");
        //将缓冲区的字符刷新到文件里
        fw.flush();
        //创建字符缓冲区，一次可读取的内容长度，尽量用字符缓冲区的方式读，更快
        char[] str = new char[1024];
        //相当于指针，指向每次读取的长度，同时成为下次读取的开始
        int len = 0;
        while ((len=reader.read(str)) != -1){
            String value = new String(str,0,len);
            System.out.println(value);
        }

        //关闭写入流，同时把缓冲区的内容写入文件
        reader.close();
        fw.close();*/

        Properties p = new Properties();
        p.setProperty("1","张三");
        p.setProperty("2","李四");
        p.setProperty("3","王五");
        p.setProperty("4","陈六");

        //遍历prop文件里的集合，将键放在set集合里
        Set<String> set = p.stringPropertyNames();
        for (String key : set) {
            //通过键取值
            String value = p.getProperty(key);
            System.out.println(key+"==>"+value);
        }

        FileWriter fw = new FileWriter("prop.properties");
        //硬盘持久化，将集合写入文件，默认写入是以 ISO-8859-1 编码写入文件
        p.store(fw,"Save prop");
        // 可以通过 OutputStreamWriter 包装 FileOutputStream，显式指定 UTF-8 编码，或者直接更改编辑器的文件编码格式
//        try {
////            FileOutputStream fos = new FileOutputStream("prop.properties");
////            OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
//            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("prop.properties"),StandardCharsets.UTF_8);
//            osw.flush();
//            p.store(osw,"Save Prop(UTF-8)");
//            osw.close();
//
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }

    }
}
