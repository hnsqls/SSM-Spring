package com.ls.ioc_04;


public class UserService {
    private String name;

    private UserDao userDao;

    public void setName(String name) {
        this.name = name;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
