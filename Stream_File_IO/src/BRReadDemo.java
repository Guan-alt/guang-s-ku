import java.io.*;
import java.util.HashMap;

/**
 * ClassName: BRReadDemo
 * Package: PACKAGE_NAME
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/27 - 8:34
 */
public class BRReadDemo {
    public static void main(String[] args) throws IOException {
        HashMap<String,String> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader("a.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("a.txt"));

    }
}
