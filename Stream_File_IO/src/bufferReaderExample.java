import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * ClassName: bufferReaderExample
 * Package: PACKAGE_NAME
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/21 - 19:02
 */
public class bufferReaderExample {
    public static void main(String[] args) {
        //生成测试文件
//        Path path = Paths.get("example");
//        try {
//            Files.write(path,"a example of BufferReader\n一个简单示例".getBytes(StandardCharsets.UTF_8));
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader("example"));
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
