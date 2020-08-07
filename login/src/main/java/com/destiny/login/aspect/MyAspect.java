package com.destiny.login.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author l_xj <l_xj@winning.com.cn>
 * @date 2020/8/5 17:27
 */
@Aspect
@Component
@SuppressWarnings({"unused"})
public class MyAspect {

    @Pointcut("@annotation(com.destiny.login.annotation.MyInfo)")
    public void annotationPointcut() {

    }

    @AfterReturning("annotationPointcut()")
    public void doAfterReturning(JoinPoint joinPoint) {
        System.out.println("注解调用方法");
    }

    @Around("annotationPointcut()")
    public Object doAroundGame(ProceedingJoinPoint pjp) throws Throwable {
        Object result=null;
        try{
            System.out.println("经纪人正在处理球星赛前事务！");
            result = pjp.proceed();
            System.out.println("返回通知：经纪人为球星表现疯狂鼓掌！");
        }
        catch(Throwable e){
            System.out.println("异常通知：球迷要求退票！");
        }
        return result;
    }
}
