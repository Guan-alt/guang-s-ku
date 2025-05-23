import java.io.File;

/**
 * ClassName: deleteFileDemo
 * Package: PACKAGE_NAME
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/21 - 18:39
 */
public class deleteFileDemo {
    public static void main(String[] args) {
        File folder = new File("D:/cn/cx/java");
        deleteFolder(folder);
    }

    //删除文件及目录
    public static void deleteFolder(File file){
        File[] files = file.listFiles();
        if(files != null){
            for (File file1 : files) {
                if(file1.isDirectory()){
                    deleteFolder(file1);
                    System.out.println(file1+"已删除");
                }else{
                    file1.delete();
                    System.out.println(file1+"已删除");
                }
            }
        }
        file.delete();
        System.out.println(file+"已删除");
    }
}
