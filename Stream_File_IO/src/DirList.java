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
        String dirName = "D:/cn";
        File f = new File(dirName);
        DiGui(f);
        //isDirectory方法，判断这个路径名代表的是否为一个目录
        //这里是用遍历输出一个目录下的所有目录或者文件，也可以用递归
//        if(f.isDirectory()){
//            System.out.println("目录："+dirName);
            //list()方法把dirName下的所有文件，目录逐一输出
//            String s[]= f.list();
//            for (String string : s) {
//                File file = new File(dirName+"/"+string);
//                if(file.isDirectory()){
//                    System.out.println(string+"是一个目录");
//                }else
//                    System.out.println(string+"是一个文件");
//            }
//        }else
//            System.out.println("不是一个目录");
    }

    //递归获得目录内所有的文件，包括子目录的也会遍历出来
    public static void DiGui(File f) {
        if(f.isDirectory()){
            String s[] = f.list();
            File file = new File(f.getAbsolutePath());
            System.out.println(file);
            for (String string : s) {
                if (file.isDirectory()) {
//                    System.out.println(string + "是一个目录");
                    File newFile = new File(file,string);
                    DiGui(newFile);
                }
            }
        }else
            System.out.println(f.getName()+"是一个文件");
    }
}
