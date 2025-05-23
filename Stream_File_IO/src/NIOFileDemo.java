import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * ClassName: NIOFileDemo
 * Package: PACKAGE_NAME
 * Dscription:文件操作：Files和Paths
 *
 * @Author: gw
 * @Creat: 2025/5/22 - 8:23
 */
public class NIOFileDemo {
    public static void main(String[] args) {
        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter("example.txt"));
//            writer.append("a example of NIO");
//            //BufferedWriter方法里用append加入的数据在缓冲区，只有关闭输入流才会把数据写入到文件
//            writer.close();
            String content = Files.readString(Paths.get("example.txt"));
            System.out.println(content);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
