import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.WeakHashMap;

/**
 * ClassName: fileStreamTest2
 * Package: PACKAGE_NAME
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/21 - 16:18
 */
public class fileStreamTest2 {
    public static void main(String[] args) throws IOException {
        /*File file = new File("a.txt");
        FileOutputStream fop = new FileOutputStream(file);
        //参数可指定编码
        OutputStreamWriter writer = new OutputStreamWriter(fop,"UTF-8");

        //将字符串存入缓冲区
        writer.append("中文输入");
        writer.append("\r");
        writer.append("English\r");
        writer.append("写入的数据");
        //每次的写入也是从文件开头开始，会覆盖掉原有的全部数据
        writer.close();//写入流关闭时把缓冲区的数据逐句写入到文件
        fop.close();//关闭输出流

        FileInputStream in = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(in,"utf-8");

        //StringBuffer 允许直接修改内容（如追加、插入、删除）
        StringBuffer sb = new StringBuffer();
        while (reader.ready()){
            sb.append((char)reader.read());
//            System.out.println(sb);
        }
        System.out.println(sb.toString());

        reader.close();
        in.close();*/

        //另一种写法,writeString可以写入字符串，默认使用utf-8编码，
        // write用于写入byte类型数据，但是也可以写入字符串，而且可以设置编码格式
        Path path = Paths.get("a.txt");
        Files.writeString(path, "中文输入\rEnglish\r输入的数据");
        String content = Files.readString(path,StandardCharsets.UTF_8);
        System.out.println(content);
    }
}
