package com.sumnear.spring4.ch1.aop;

import org.springframework.stereotype.Service;

/**
 * @author sumnear
 */

@Service
public class DemoAnnotationService
{

    @Action(name = "注解式拦截的add操作")
    public void add()
    {
        System.out.println("DemoAnnotationService  add");
    }
}
