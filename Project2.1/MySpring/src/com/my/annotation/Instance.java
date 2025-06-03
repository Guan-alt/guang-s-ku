package com.my.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: Instance
 * Package: com.my.annotation
 * Dscription:此注解用于依赖注入，与Spring @AutoWried注解相同。
 * 当dao层的对象里使用了该注解时，程序运行时，容器就会把这个对象实例化并放进容器里，不过这里使用的单例
 *
 * @Author: gw
 * @Creat: 2025/6/3 - 11:33
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Instance {
}
