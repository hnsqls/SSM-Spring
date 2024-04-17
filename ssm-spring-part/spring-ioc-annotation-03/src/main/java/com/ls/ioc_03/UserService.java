package com.ls.ioc_03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    //setter方法注入
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    //构造器注入
    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void show(){
        userDao.call();
    }
}
