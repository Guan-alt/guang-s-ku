/**
 * ClassName: C
 * Package: PACKAGE_NAME
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/15 - 17:41
 */
public class C extends B{
    public void show(){
        super.show();
    }
    public void show2(){
        System.out.println("C");
    }

    public static void main(String[] args) {
        A a = new A();
        a.show();
        B b = new B();
        b.show();
        C c = new C();
        c.show();
        A d = new B();
        d.show();
        A e = new C();
        e.show();
    }
}
