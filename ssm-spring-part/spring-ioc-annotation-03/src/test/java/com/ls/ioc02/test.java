package com.ls.ioc02;

import com.ls.ioc_02.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    /**
     * 测试周期性方法
     * @param args
     */
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-02.xml");
        Person bean = context.getBean(Person.class);

        context.close();

    }
}
