package com.sumnear.spring4.ch1.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @authore sumnear
 * @create 2019-2-18 15:10
 */

@Configuration
public class JavaConfig
{
    @Bean
    public FunctionService functionService()
    {
        return new FunctionService();
    }

    @Bean
    public UseFunctionService useFunctionService()
    {
        UseFunctionService useFunctionService = new UseFunctionService();
        useFunctionService.setFunctionService(functionService());
        return useFunctionService;
    }
}
