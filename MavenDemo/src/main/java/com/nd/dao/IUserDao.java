package com.nd.dao;

import com.nd.entity.User;

import java.util.List;

/**
 * ClassName: IUserDao
 * Package: com.nd.dao
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/6/6 - 18:04
 */
public interface IUserDao {
    public List<User> findAll();
}
