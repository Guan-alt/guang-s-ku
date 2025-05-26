package test;

import java.io.*;

/**
 * ClassName: Test1
 * Package: test
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/26 - 11:05
 */
public class Test1 {
    public static void main(String[] args) throws IOException {
        InputStream f = new FileInputStream("a.txt");
        //这里循环是先判断读的值是否为-1，然后指针指向下一个值，这时输出的就是第二个值，
        // 每次调用方法，指针都会指向下一个元素
        while (f.read() != -1){
            System.out.println(f.read());
        }

    }
}
