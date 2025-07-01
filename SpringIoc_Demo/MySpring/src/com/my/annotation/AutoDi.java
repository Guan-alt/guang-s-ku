package com.my.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: AutuDi
 * Package: com.my.annotation
 * Dscription:此注解用于定义一个对象，与Spring @Component注解相同。
 * 这个注解声明的对象应该是在容器里的，该对象已经在容器里被实例化了，声明后就可以直接调用其属性和方法
 *
 * @Author: gw
 * @Creat: 2025/6/3 - 11:32
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoDi {
}
