package com.sumnear.spring4.ch3.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionConifg
{
//    如果配置中有多个Conditional为true则容器启动报错expected single matching bean but found 2
//    @Bean
//    @Conditional(TestCondition.class)
//    public ListService testListService() {
//        return new LinuxListService();
//    }

    @Bean
    @Conditional(WindowsCondition.class)
    public ListService windowsListService()
    {
        return new WindowsListService();
    }

    @Bean
    @Conditional(LinuxCondition.class)
    public ListService linuxListService()
    {
        return new LinuxListService();
    }

}
