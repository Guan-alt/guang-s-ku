import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * ClassName: FileChannelDeom
 * Package: PACKAGE_NAME
 * Dscription:通道（Channel）是NIO中的核心概念，允许在缓冲区之间高效地传输数据
 *
 * @Author: gw
 * @Creat: 2025/5/22 - 15:22
 */
public class FileChannelDemo {
    public static void main(String[] args) {
        try {
//            Files.write(Paths.get("source.txt"),"这是来源文件内容".getBytes(StandardCharsets.UTF_8));

            //分别创建文件输入流输出流
            FileInputStream fis = new FileInputStream("source.txt");
            FileOutputStream fos = new FileOutputStream("destination.txt");
            //分别创建FileChannel 对象，代表与文件或流关联的通道。
            FileChannel inChannel = fis.getChannel();
            FileChannel outChannel = fos.getChannel();

            //创建字符缓冲区，容量为1024，此时缓冲区为写模式，每次只能读取1024容量的字节数据
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            //从输入通道输出字符到缓冲区，仅当读取到数据（返回值>0）时，进入循环体。
            //同时得到一个返回值：实际读取的字节数。如果返回-1，表示到达流的末尾（如文件末尾）
            while (inChannel.read(buffer) > 0){
                //切换模式为读模式，写模式下，继续写入会覆盖未读取的数据（即超出缓冲区容量的数据）。切换到读模式后，只能读取已写入的部分
                buffer.flip();
                outChannel.write(buffer);
                //将缓冲区已读取的内容清除，腾出空间来下次从管道读取内容
                buffer.clear();
            }
            //全部内容读取完后提示
            System.out.println("file copied successfully");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
