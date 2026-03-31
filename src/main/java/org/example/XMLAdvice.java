package org.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

public class XMLAdvice {

    public void before() {
        System.out.println("连接数据库");
    }
    public void after(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println("对于id为："+Arrays.toString(joinPoint.getArgs()) +"执行"+name+"方法成功");
    }
    public void afterReturning(JoinPoint joinPoint, Object flag) {
        String name = joinPoint.getSignature().getName();
        System.out.println("对于id为："+Arrays.toString(joinPoint.getArgs()) +"执行"+name+"方法"+flag);
    }
    //环绕通知，模拟前面所有的通知类型，一定要告诉方法切入点的位置
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("连接数据库");
        Object flag = joinPoint.proceed();
        System.out.println("执行成功");
        return flag;
    }
}
