package com.ls.ioc03;

import com.ls.ioc_03.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-03.xml");

        UserService bean = context.getBean(UserService.class);
        bean.show();
    }
}
