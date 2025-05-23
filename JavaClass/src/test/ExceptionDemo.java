package test;

import java.awt.event.FocusEvent;
import java.util.Scanner;

/**
 * ClassName: ExceptionDemo
 * Package: test
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/22 - 8:59
 */
public class ExceptionDemo{
    public static void main(String[] args){
        String[] person = {"张三","李四","王五"};
        System.out.println("输入用户名：");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.next();
        for (String s : person) {
            if(s.equals(userName)){
                throw new RegisterException(userName);
            }
        }
        System.out.println("注册成功");
    }


}
