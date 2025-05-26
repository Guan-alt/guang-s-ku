import java.io.*;

/**
 * ClassName: fileStreamTest
 * Package: PACKAGE_NAME
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/21 - 15:26
 */
public class fileStreamTest {
    public static void main(String[] args) {
        try {
            byte bWrite[] = {8,6};
            //字节输出流超类，写入数据，文件不存在自动创建,true追加，false（默认）覆盖
            // stream(file f,boolean b)，b可以指定对文件的操作为追加还是覆盖,
            OutputStream os = new FileOutputStream("test.txt",true);
            for (int i = 0; i < bWrite.length; i++) {
                //每次写入数据从文件开头开始，会覆盖全部已写入的数据
                os.write(bWrite[i]);
            }
            os.close();

            //字节输入超类创建对象
            InputStream is = new FileInputStream("test.txt");
            //available方法估算需要分配的缓冲区大小。
            //判断流是否已结束（返回 0 可能表示无数据，但不一定表示流结束)
            int size = is.available();

            for (int i = 0; i < size; i++) {
                System.out.println(is.read()+" ");
            }
            is.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
