package com.ls.ioc_05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    /**获取ioc容器并使用bean
     * @param args
     */
    public static void main(String[] args) {
        //方式一：直接创建容器并指定配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ioc_05.xml");

        //方式二： 先创建ioc容器，在指定配置文件，在刷新
//        ClassPathXmlApplicationContext context1 = new ClassPathXmlApplicationContext(); //创建ioc容器
//        context1.setConfigLocations("ioc_05.xml");   //配置ioc容器
//        context1.refresh();   //刷新ioc容器。

        Dog dog = context.getBean("dog", Dog.class);
        dog.eat();

    }
}
