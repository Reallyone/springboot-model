package com.hjx.system.aop.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 定义切面类：在类上添加@Aspect 和@Component 注解即可将一个类定义为切面类。
 *
 * @Aspect 注解 使之成为切面类
 * @Component 注解 把切面类加入到IOC容器中
 */
@Aspect
@Component
public class BrokerAspect {
    /**
     * 定义切入点，切入点为com.example.demo.aop.AopController中的所有函数
     * 通过@Pointcut注解声明频繁使用的切点表达式
     */
    @Pointcut("execution(public * com.hjx.system.aop.AopController.*(..)))")
    public void BrokerAspect() {

    }

    /**
     * @description 在连接点执行之前执行的通知
     */
    @Before("BrokerAspect()")
    public void doBeforeGame() {
        System.out.println("经纪人正在处理球星赛前事务！");
    }

    /**
     * @description 在连接点执行之后执行的通知（返回通知和异常通知的异常）
     */
    @After("BrokerAspect()")
    public void doAfterGame() {
        System.out.println("经纪人为球星表现疯狂鼓掌！");
    }

    /**
     * @description 在连接点执行之后执行的通知（返回通知）
     */
    @AfterReturning("BrokerAspect()")
    public void doAfterReturningGame() {
        System.out.println("返回通知：经纪人为球星表现疯狂鼓掌！");
    }

    /**
     * @description 在连接点执行之后执行的通知（异常通知）
     */
    @AfterThrowing("BrokerAspect()")
    public void doAfterThrowingGame() {
        System.out.println("异常通知：球迷要求退票！");
    }


}
