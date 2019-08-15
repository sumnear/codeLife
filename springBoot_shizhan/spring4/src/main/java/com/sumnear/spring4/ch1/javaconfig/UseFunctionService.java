package com.sumnear.spring4.ch1.javaconfig;

/**
 * @authore sumnear
 * @create 2019-2-18 14:59
 */
public class UseFunctionService
{
    FunctionService functionService;

    public void setFunctionService(FunctionService functionService)
    {
        this.functionService = functionService;
    }

    public String sayHello(String word)
    {
        return functionService.sayHello(word);
    }
}
