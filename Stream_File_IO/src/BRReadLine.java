import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ClassName: BRReadLine
 * Package: PACKAGE_NAME
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/21 - 8:39
 */
public class BRReadLine {
    public static void main(String[] args) throws IOException {
        //用system.in创建bufferedread
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //用于接收字符串
        String str;
        System.out.println("输入一行字符串，输入end结束");
        //检测到end就会退出
        do{
            str = br.readLine();
            System.out.println(str);
        }while (!str.equals("end"));//字符串的内容比较用equals方法
        /**
         * 相比于read方法，readline方法只有单独输入结束检测字符串才会退出
         * read方法由于是逐个读字符，qun读到第一个就会退出
         */

    }
}
