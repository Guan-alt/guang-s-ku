import java.io.File;

/**
 * ClassName: DrList
 * Package: PACKAGE_NAME
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/21 - 18:16
 */
public class DirList {

    public static void main(String[] args) {
        String dirName = "D:/code/tomcat";
        File f = new File(dirName);
        //isDirectory方法，判断这个路径名代表的是否为一个目录
        if(f.isDirectory()){
            System.out.println("目录："+dirName);
            //list()方法把dirName下的所有文件，目录逐一输出
            String s[]= f.list();
            for (String string : s) {
                File file = new File(dirName+"/"+string);
                if(file.isDirectory()){
                    System.out.println(string+"是一个目录");
                }else
                    System.out.println(string+"是一个文件");
            }
        }else
            System.out.println("不是一个目录");
    }
}
