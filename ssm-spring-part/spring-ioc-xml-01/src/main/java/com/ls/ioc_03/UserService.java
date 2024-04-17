package com.ls.ioc_03;

public class UserService {
    private int age;
    private String name;

    private UserDao userDao;

    public UserService(int age, String name, UserDao userDao) {
        this.age = age;
        this.name = name;
        this.userDao = userDao;
    }
}
