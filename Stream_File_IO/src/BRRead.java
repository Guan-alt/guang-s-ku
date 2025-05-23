import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ClassName: BRRead
 * Package: PACKAGE_NAME
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/21 - 8:31
 */
public class BRRead {
    public static void main(String[] args) throws IOException {
        //接收输入字符
        char c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //读到q就会退出B
        System.out.println("输入字符串，q退出：");
        do{
            c = (char) br.read();
            System.out.println(c);
        }while (c != 'q');

    }
}
