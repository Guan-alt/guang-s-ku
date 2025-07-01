package com.my.core;

/**
 * ClassName: BenFactory
 * Package: com.my.core.context
 * Dscription:容器工厂接口
 *
 * @Author: gw
 * @Creat: 2025/6/3 - 11:33
 */
public interface BeanFactory {
    /**
     * 根据对象名获取 Bean
     * @param beanName 对象名
     * @return
     */
    Object getBean(String beanName);
}
