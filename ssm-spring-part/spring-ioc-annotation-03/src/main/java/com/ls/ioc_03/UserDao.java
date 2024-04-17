package com.ls.ioc_03;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    public void call(){
        System.out.println("userDao执行");
    }
}
