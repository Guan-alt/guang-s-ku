import java.io.File;

/**
 * ClassName: creatDir
 * Package: PACKAGE_NAME
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/21 - 17:30
 */
public class creatDir {
    public static void main(String[] args) {
        String dirName = "/cn/cx/java/test";
        File f = new File(dirName);
        //创建目录，这里创建的目录在D盘
        f.mkdirs();

    }
}
