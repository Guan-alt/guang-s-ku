package test;

/**
 * ClassName: ExceptinHasPerson
 * Package: PACKAGE_NAME
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/5/22 - 9:02
 */
public class RegisterException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public RegisterException(){
        super("亲，该用户名已被注册");
    }
    public RegisterException(String userName){super("用户名："+"“"+userName+"”"+"已被注册！");}

    //try...catch使用，catch类名 e，参数为想显示的信息，e
    public RegisterException(String message,Throwable cause){
        super(message, cause.fillInStackTrace());
    }
}
