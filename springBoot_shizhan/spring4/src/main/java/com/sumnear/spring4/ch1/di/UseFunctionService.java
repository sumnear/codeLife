package com.sumnear.spring4.ch1.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @authore sumnear
 * @create 2019-2-18 14:59
 */
@Service
public class UseFunctionService
{
    @Autowired
//    @Resource
    FunctionService functionService;

    public String sayHello(String word)
    {
        return functionService.sayHello(word);
    }
}
