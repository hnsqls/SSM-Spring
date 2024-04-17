package com.ls.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;

/** 获得目标方法的信息
 *      任何增强方法都可以获得  目标方法的类名 方法名，参数。
 *       JoinPoint    import org.aspectj.lang.JoinPoint;
 *      1. 目标方法的类名
 *          joinPoint.getTarget().getClass().getName();
 *      2. 目标方法名以及方法的访问修饰符
 *          joinPoint.getSignature().getName();
 *          joinPoint.getSignature().getModifier();//需要注意的是，返回值是整数，
 *                   int modifiers = joinPoint.getSignature().getModifiers();
 *                    String string = Modifier.toString(modifiers);
 *
 *
 *      3.返回值 @AfterReturning
 *      1. @AfterReturning("execution(xxx)",returning = "自定义参数名")
 *      2. 在增强方法中传参 public void afterReturning(Object 自定义参数名)
 *
 *      4.异常信息 @AfterThrowing
 *       1.   @AfterThrowing(value = "execution(* com.ls.service.CalculatorPureImpl.*(..))",throwing = "error")
 *       2. public void afterThrowing(Throwable error)
 *
 */
@Aspect
@Component
public class MyAdvice {
    @Before("execution(* com.ls.service.CalculatorPureImpl.*(..))")
    public  void before(JoinPoint joinPoint){
        //获得目标类的类名
        String name = joinPoint.getTarget().getClass().getName();
        System.out.println("name = " + name);
        //方法的访问修饰符
        int modifiers = joinPoint.getSignature().getModifiers();
        String string = Modifier.toString(modifiers);
        System.out.println("joinPoint = " + joinPoint);
        //方法名称
        String name1 = joinPoint.getSignature().getName();
        System.out.println("joinPoint = " + joinPoint);
        //参数列表
        Object[] args = joinPoint.getArgs();
        System.out.println("args = " + args);

        System.out.println("before");
    }

    @AfterReturning(value = "execution(* com.ls.service.CalculatorPureImpl.*(..))",returning = "result")
    public void afterReturning(Object result){
        System.out.println("result = " + result);
        System.out.println("方法结束");
    }

    @AfterThrowing(value = "execution(* com.ls.service.CalculatorPureImpl.*(..))",throwing = "error")
    public void afterThrowing(Throwable error){
        System.out.println("方法报错");
    }
    @After("execution(* com.ls.service.CalculatorPureImpl.*(..))")
    public void after(){
        System.out.println("方法关闭");

    }
}
