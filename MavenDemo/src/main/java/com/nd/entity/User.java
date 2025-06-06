package com.nd.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: entity
 * Package: com.nd
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/6/6 - 17:57
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1;

    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;

    public User() {}
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
