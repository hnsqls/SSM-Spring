package com.ls.jdbc;

import com.ls.controller.StudentController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MvcPractice {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("application.xml");

        //发送请求，controller接受请求
        StudentController controller = applicationContext.getBean(StudentController.class);
        controller.findAll();
    }
}
