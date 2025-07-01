package com.my.dao.impl;

import com.my.annotation.Instance;
import com.my.dao.UserDao;

/**
 * ClassName: UserDaoImpl
 * Package: com.my.dao.impl
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/6/3 - 11:35
 */
@Instance//在dao层使用了该注解的对象都会被实例化后放进容器
public class UserDaoImpl implements UserDao {
    public UserDaoImpl() {
    }

    public void save() {
        System.out.println("执行了dao的save");
    }
}
