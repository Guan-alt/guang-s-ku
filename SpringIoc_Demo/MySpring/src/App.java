import com.my.core.context.ApplicationContext;
import com.my.service.UserService;

/**
 * ClassName: App
 * Package: PACKAGE_NAME
 * Dscription:测试类
 *
 * @Author: gw
 * @Creat: 2025/6/3 - 11:36
 */
public class App {
    public static void main(String[] args) {
        // 创建容器
        ApplicationContext context = new ApplicationContext("com.my");
        // 从容器中获取对象
        UserService userService = (UserService)context.getBean("userServiceImpl");
        // 调用对象方法
        userService.save();
    }
}

