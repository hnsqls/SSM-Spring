package com.ls.advice;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 *  1. 定义方法的增强方法
 *       根据核心代码，需要执行非核心代码的插入位置，编写对应的方法 *
 *  2. 使用注解配置，插入目标方法的位置
 *      前置 @Before
 *      后置 @AfterReturning
 *      异常 @AfterThrowing
 *      结束 @After
 *      环绕 @Around
 *
 *   3. 配置切点 --->切点表达式
 *
 *
 *   4. 补全注解
 *         加入ioc容器 @Component
 *         配置切面   @Aspect
 *
 *    5. 开启AspectJ 注解
 *      xml  <aop:aspectj-autoproxy/>
 *      配置类 @EnableAspectJAutoProxy
 *
 *
 */
@Aspect
@Component
public class Log {

    @Before("execution(* com.ls.service.CalculatorPureImpl.*(..))")
    public  void start(){
        System.out.println("方法开始");
    }

    @AfterReturning("execution(* com.ls.service.CalculatorPureImpl.*(..))")
    public void after(){
        System.out.println("方法结束");
    }

    @AfterThrowing("execution(* com.ls.service.CalculatorPureImpl.*(..))")
    public void error(){
        System.out.println("方法报错");
    }
}
