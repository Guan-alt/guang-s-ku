package com.my.service.impl;

import com.my.annotation.AutoDi;
import com.my.annotation.Instance;
import com.my.dao.UserDao;
import com.my.service.UserService;

/**
 * ClassName: UserServiceImpl
 * Package: com.my.service.impl
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/6/3 - 11:36
 */
@Instance
public class UserServiceImpl implements UserService {
    @AutoDi
    private UserDao userDao;//使用了@AutoDi注解，这里是直接从容器里取出了UserDao的实例对象，相当于UserDao userDao=new UserDao();

    public UserServiceImpl() {
    }

    public void save() {
        this.userDao.save();
    }
}
