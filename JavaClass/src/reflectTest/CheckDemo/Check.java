package reflectTest.CheckDemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: Check
 * Package: reflectTest.CheckDemo
 * Dscription:标记
 *
 * @Author: gw
 * @Creat: 2025/5/26 - 20:20
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Check {
}
