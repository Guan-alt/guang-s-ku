package reflectTest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: NoteDemo
 * Package: reflectTest
 * Dscription:自定义注解，用于替换配置文件内容，或责测试
 *
 * @Author: gw
 * @Creat: 2025/5/23 - 9:28
 */

/**
 * 1.@Target
 *作用：指定自定义注解可以应用的目标元素类型（如类、方法、字段等）。
 *属性：value（ElementType[] 数组）。
 * 2.@Retention
 * 作用：定义注解的保留策略，决定注解在何时有效（源码、类文件、运行时）。
 * 属性：value（RetentionPolicy 枚举）。
 * 3.@Documented
 * 作用：标记注解是否应包含在生成的 JavaDoc 中。
 * 4.@Inherited
 * 作用：允许子类继承父类上的注解（仅对类级别的注解有效）。
 * 5.@Repeatable（Java 8+）
 * 作用：允许同一注解在同一个元素上多次使用。
 * 属性：value（指定容器注解的类）。
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface NoteDemo {
    String className();
    String[] methodName();
}
