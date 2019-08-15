package com.sumnear.spring4.ch1.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect //1
@Component //2
public class LogAspect
{

    @Pointcut("@annotation(com.sumnear.spring4.ch1.aop.Action)") //3
    public void annotationPointCut()
    {
    }

    @After("annotationPointCut()") //4
    public void after(JoinPoint joinPoint)
    {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("注解式拦截 " + action.name());
    }

    @Around("annotationPointCut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable
    {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("aroundaroundaroundaroundaroundaround注解式拦截 " + action.name());
        joinPoint.proceed();
        System.out.println("aroundaroundaroundaroundaroundaround注解式拦截 " + action.name());


    }

    @Before("execution(* com.sumnear.spring4.ch1.aop.DemoMethodService.*(..))") //6
    public void before(JoinPoint joinPoint)
    {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则式拦截," + method.getName());

    }


}
