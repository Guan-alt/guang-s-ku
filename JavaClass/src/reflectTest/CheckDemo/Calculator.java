package reflectTest.CheckDemo;

/**
 * ClassName: Calculator
 * Package: reflectTest.CheckDemo
 * Dscription:测试对象
 *
 * @Author: gw
 * @Creat: 2025/5/26 - 20:20
 */
public class Calculator {
    @Check
    public void add(){
        String str = null;
        str.toString();
        System.out.println("1+0="+(1+0));
    }

    @Check
    public void sub(){
        System.out.println("1-0="+(1-0));
    }

    @Check
    public void mul(){
        System.out.println("1*0="+1*0);
    }

    @Check
    public void div(){
        System.out.println("1/0="+(1/0));
    }

    public void show(){
        System.out.println("无bug");
    }
}
