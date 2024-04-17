package com.ls.ioc01;

import com.ls.ioc_01.UserController;
import com.ls.ioc_01.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Ioctest {
    public static void main(String[] args) {
        //获取ioc
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-01.xml");

        //获取bean
//        UserService bean1 = applicationContext.getBean(UserService.class);
        UserController bean = applicationContext.getBean(UserController.class);
        bean.show();

    }



}
