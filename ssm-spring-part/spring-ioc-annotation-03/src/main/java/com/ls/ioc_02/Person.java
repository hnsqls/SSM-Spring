package com.ls.ioc_02;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 周期方法和作用域的练习
 *      周期性方法  @PostConstruct  @PreDestory
 *             需要导入 javax.annotation-api
 *     作用域： @Scope
 *               scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE
 *               scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON
 *

 */
@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)

public class Person {


    //周期方法必须 public void 修饰，并且无参
//    导入依赖javax.annotation-api，才能使用这个注解
    @PostConstruct
    public  void  one(){
        System.out.println("起床~~~~");
    }

    @PreDestroy
    public void end(){
        System.out.println("睡觉~~~~~");
    }

}
